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
    private JPanel mainPanel;
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
    private JButton previewsButton1;
    private JButton audioButton1;
    private JButton button1;
    private JButton iconsButton;

    public static JFrame previewsFrame = null;
    public static JFrame audioFrame = null;

    public static ActionListener srchAction = null;

    private ArrayList<String> imagesPaths;

    public static String AT9TOOL = "";
    public static String OUTPUT = ""; //TODO make private

    public static String themeTitle = "";

    private Main() {
        imagesPaths = new ArrayList<String>();
        lessButton.setEnabled(false);

        final JPanel[] extraPanels = {
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
            if (panel != null) {
                panel.setVisible(false);
            }
        }

        srchAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                JTextField textField = (JTextField) button.getParent().getComponent(0);

                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("png files (*.png)", "png");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(mainPanel);
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
                if (button.getText().equalsIgnoreCase("+")) {
                    for (int x = 3; x < 12; x++) {
                        JPanel childPanel = (JPanel) contentPanel.getAccessibleContext().getAccessibleChild(x);
                        int position = Integer.parseInt(childPanel.getToolTipText().split(" ")[1]);
                        JPanel selectedPanel = extraPanels[position];
                        if (!selectedPanel.isVisible()) {
                            selectedPanel.setVisible(true);

                            if (selectedPanel.getToolTipText().split(" ")[1].equalsIgnoreCase("10")) {
                                plusButton.setEnabled(false);
                            }
                            lessButton.setEnabled(true);
                            break;
                        }
                    }
                } else {
                    for (int x = 11; x > 2; x--) {
                        JPanel childPanel = (JPanel) contentPanel.getAccessibleContext().getAccessibleChild(x);
                        int position = Integer.parseInt(childPanel.getToolTipText().split(" ")[1]);
                        JPanel selectedPanel = extraPanels[position];
                        if (selectedPanel.isVisible()) {
                            selectedPanel.setVisible(false);
                            JTextField textField = (JTextField) selectedPanel.getAccessibleContext().getAccessibleChild(0);
                            textField.setText("");

                            if (selectedPanel.getToolTipText().split(" ")[1].equalsIgnoreCase("2")) {
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
                if (minimumRequirements()) {
                    themeTitle = themeTitleTextField.getText().trim();

                    // Create necessary directories
                    File directory = new File(OUTPUT);
                    if (!directory.exists()) {
                        System.out.println("Directory created: " + directory.mkdir());
                    }

                    directory = new File(OUTPUT + themeTitle);
                    if (!directory.exists()) {
                        System.out.println("Directory created: " + directory.mkdir());
                    } else {
                        for(File file : directory.listFiles()) {
                            file.delete();
                        }
                    }

                    // Backgrounds
                    createBackgroundImages();
                    generateThumbnails();

                    // LockScreen
                    try {
                        BufferedImage lockscreen = ImageFormatter.convertRGBAToIndexed(ImageIO.read(new File(lockScreenPath.getText().trim())), false, 0, 0);
                        ImageIO.write(lockscreen, "png", new File(OUTPUT + themeTitle + "/start_bg.png"));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    // Previews
                    generatePreviews();

                    // Audio

                    //TODO FINISH THIS (CHANGE RESULT PATH JEJE)
                    if(!Audio.wavFilePath.isEmpty()) {
                        try {
                            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd " + Main.OUTPUT + ".. && at9tool -e -br 144 -wholeloop " + Audio.wavFilePath + " BGM.at9\"");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                    // Icons

                    JOptionPane.showMessageDialog(new JInternalFrame(), "     Finished sucessfully!", "Message", 1);
                } else {
                    JOptionPane.showMessageDialog(new JInternalFrame(), "     Required fields are empty!", "Error", 2);
                }
            }
        });
        previewsButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              previewsFrame.setSize(400, 230);
              previewsFrame.setLocationRelativeTo(null);
              previewsFrame.setVisible(true);
            }
        });
        audioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                audioFrame.setSize(400, 230);
                audioFrame.setLocationRelativeTo(null);
                audioFrame.setVisible(true);
            }
        });
    }

    private void createBackgroundImages() {
        imagesPaths.clear();
        getTextFieldsPaths();
        ArrayList<BufferedImage> readyImages = new ArrayList<BufferedImage>();

        for (String path : imagesPaths) {
            try {
                readyImages.add(ImageFormatter.convertRGBAToIndexed(ImageIO.read(new File(path)), false, 0, 0));
            } catch (IOException e) {
                e.printStackTrace();
            }
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
                ImageIO.write(image, "png", new File(OUTPUT + themeTitle + "/bg_" + finalNumber + ".png"));
                number++;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void generateThumbnails() {
        File directory = new File(OUTPUT + themeTitle);
        File[] files = directory.listFiles();

        for (File file : files) {
            try {
                BufferedImage image = ImageFormatter.convertRGBAToIndexed(ImageIO.read(file), true, 360, 192);
                ImageIO.write(image, "png", new File(OUTPUT + themeTitle + "/" + file.getName().substring(0, 5) + "t.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void generatePreviews() {
        if(!Previews.previewsPath[0].isEmpty() || !Previews.previewsPath[1].isEmpty() || !Previews.previewsPath[2].isEmpty()) {

            String pathLockScreen = Previews.previewsPath[0];
            String pathPage = Previews.previewsPath[1];
            String pathThumbnail = Previews.previewsPath[2];

            BufferedImage image = null;
            try {
                if(!pathLockScreen.isEmpty()) {
                    image = ImageFormatter.convertRGBAToIndexed(ImageIO.read(new File(pathLockScreen)), true, 480, 272);
                    ImageIO.write(image, "png", new File(OUTPUT + themeTitle + "/preview_lockscreen.png"));
                }

                if(!pathPage.isEmpty()) {
                    image = ImageFormatter.convertRGBAToIndexed(ImageIO.read(new File(pathPage)), true, 480, 272);
                    ImageIO.write(image, "png", new File(OUTPUT + themeTitle + "/preview_page.png"));
                }

                if(!pathThumbnail.isEmpty()) {
                    image = ImageFormatter.convertRGBAToIndexed(ImageIO.read(new File(pathThumbnail)), true, 226, 128);
                    ImageIO.write(image, "png", new File(OUTPUT + themeTitle + "/preview_thumbnail.png"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private void getTextFieldsPaths() {
        for (int x = 2; x < 12; x++) {
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

        if (themeTitleTextField.getText().trim().isEmpty()) {
            result = false;
        } else if (authorNameTextField.getText().trim().isEmpty()) {
            result = false;
        } else if (lockScreenPath.getText().trim().isEmpty()) {
            result = false;
        } else if (page1Path.getText().trim().isEmpty()) {
            result = false;
        }

        return result;
    }

    public static void main(String[] args) {
        //Get JAR LOCATION
        String JARPATH = "";
        try {
            JARPATH = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParent() + "/";
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        // Main Frame creation
        JFrame frame = new JFrame("PsVita Theme Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Main().mainPanel);
        frame.setSize(550, 400);
//        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Preview Frame creation
        previewsFrame = new JFrame("Previews");
        previewsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        previewsFrame.setContentPane(new Previews().mainPanel);

        // Audio Frame creation
        audioFrame = new JFrame("Audio");
        audioFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        audioFrame.setContentPane(new Audio().mainPanel);

        // AT9TOOL.EXE LOCATION
        AT9TOOL = JARPATH + "at9tool.exe";

        if(!new File(AT9TOOL).exists()){
            JOptionPane.showMessageDialog(new JInternalFrame(), "     at9tool.exe not found", "Message", 2);
        }

        // THEME DIRECTORY
        OUTPUT = JARPATH + "Themes/";

        System.out.println(AT9TOOL);
        System.out.println(OUTPUT);
    }
}
