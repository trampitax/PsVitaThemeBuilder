import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {
    private JPanel panelMain;
    private JTextField themeTitleTextField;
    private JTextField authorNameTextField;
    private JButton buildButton;
    private JTextField lockScreenPath;
    private JButton searchButtonLockScreen;
    private JButton searchButton01Background;
    private JPanel contentPanel;
    private JButton searchButton02Background;
    private JButton searchButton03Background;
    private JButton searchButton04Background;
    private JButton searchButton05Background;
    private JButton searchButton06Background;
    private JButton searchButton07Background;
    private JButton searchButton08Background;
    private JButton searchButton09Background;
    private JButton searchButton10Background;
    private JTextField page1Path;
    private JLabel infoLabel;
    private JPanel page2Panel;
    private JPanel page3Panel;
    private JPanel page4Panel;
    private JPanel page5Panel;
    private JPanel page6Panel;
    private JPanel page7Panel;
    private JPanel page8Panel;
    private JPanel page9Panel;
    private JPanel page10Panel;
    private JButton plusButton;
    private JButton lessButton;

    private ArrayList<String> imagesPaths;

    private Main() {
        imagesPaths = new ArrayList<String>();
        lessButton.setEnabled(false);

        final JPanel [] extraPanels = {
                null,
                null,
                page2Panel,
                page3Panel,
                page4Panel,
                page5Panel,
                page6Panel,
                page7Panel,
                page8Panel,
                page9Panel,
                page10Panel
        };

        for (JPanel panel : extraPanels) {
            if(panel != null) {
                panel.setVisible(false);
            }
        }

        getTextFieldsPaths();

        ActionListener srchAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                JTextField textField = (JTextField) button.getParent().getComponent(0);
                System.out.println();

                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("png files (*.png)", "png");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(panelMain);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                    String filePath = chooser.getSelectedFile().getAbsolutePath();
                    textField.setText(filePath);
                }
            }
        };

        ActionListener viewPanel = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                if(button.getText().equalsIgnoreCase("+")) {
                    for(int x = 3; x < 12; x++) {
                        JPanel childPanel = (JPanel) contentPanel.getAccessibleContext().getAccessibleChild(x);
                        int position = Integer.parseInt(childPanel.getToolTipText().split(" ")[1]);
                        JPanel selectedPanel = extraPanels[position];
                        if(!selectedPanel.isVisible()) {
                            selectedPanel.setVisible(true);

                            if(selectedPanel.getToolTipText().split(" ")[1].equalsIgnoreCase("10")) {
                                plusButton.setEnabled(false);
                            }
                            lessButton.setEnabled(true);
                            break;
                        }
                    }
                } else {
                    for(int x = 11; x > 2; x--) {
                        JPanel childPanel = (JPanel) contentPanel.getAccessibleContext().getAccessibleChild(x);
                        int position = Integer.parseInt(childPanel.getToolTipText().split(" ")[1]);
                        JPanel selectedPanel = extraPanels[position];
                        if(selectedPanel.isVisible()) {
                            selectedPanel.setVisible(false);
                            JTextField textField = (JTextField) selectedPanel.getAccessibleContext().getAccessibleChild(0);
                            textField.setText("");

                            if(selectedPanel.getToolTipText().split(" ")[1].equalsIgnoreCase("2")) {
                                lessButton.setEnabled(false);
                            }
                            plusButton.setEnabled(true);
                            break;
                        }
                    }
                }
            }
        };

        plusButton.addActionListener(viewPanel);
        lessButton.addActionListener(viewPanel);

        searchButtonLockScreen.addActionListener(srchAction);
        searchButton01Background.addActionListener(srchAction);
        searchButton02Background.addActionListener(srchAction);
        searchButton03Background.addActionListener(srchAction);
        searchButton04Background.addActionListener(srchAction);
        searchButton05Background.addActionListener(srchAction);
        searchButton06Background.addActionListener(srchAction);
        searchButton07Background.addActionListener(srchAction);
        searchButton08Background.addActionListener(srchAction);
        searchButton09Background.addActionListener(srchAction);
        searchButton10Background.addActionListener(srchAction);

        buildButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Build button pressed");

                if(minimumRequirements()) {
                    infoLabel.setText("Building your theme...");
                    ArrayList<BufferedImage> readyImages = new ArrayList<BufferedImage>();
                    for (String path : imagesPaths) {
                        readyImages.add(ImageFormatter.convertRGBAToIndexed(path));
                    }

                    int number = 1;
                    String finalNumber = "";

                    for (BufferedImage image : readyImages) {
                        try {
                            if (number < 10) {
                                finalNumber = "0" + number;
                            } else {
                                finalNumber = "" + number;
                            }
                            ImageIO.write(image, "png", new File("outImages/bg_" + finalNumber + ".png"));
                            number++;
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    infoLabel.setText("Finished sucessfully!");
                } else {
                    infoLabel.setText("<html><font color='red'>Required fields are empty!</font></html>");
                }
            }
        });
    }

    private void getTextFieldsPaths() {
        for (int x = 1; x < 12; x++) {
            JPanel thePanel = (JPanel) contentPanel.getAccessibleContext().getAccessibleChild(x);
            if (thePanel.isVisible()) {
                JTextField pathTextField = (JTextField) thePanel.getAccessibleContext().getAccessibleChild(0);
                if (!pathTextField.getText().isEmpty()) {
                    imagesPaths.add(pathTextField.getText());
                }
            }
        }
    }

    private boolean minimumRequirements() {
        boolean result = true;

        if(themeTitleTextField.getText().trim().isEmpty()) {
            result = false;
        } else if(authorNameTextField.getText().trim().isEmpty()) {
            result = false;
        } else if(lockScreenPath.getText().trim().isEmpty()) {
            result = false;
        } else if(page1Path.getText().trim().isEmpty()) {
            result = false;
        }

        return result;
    }

    public static void main(String[] args) {
        //Get JAR LOCATION
        try {
            System.out.println(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        // Frame creation
        JFrame frame = new JFrame("PsVita Theme Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Main().panelMain);
        frame.setSize(450, 300);
//        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
