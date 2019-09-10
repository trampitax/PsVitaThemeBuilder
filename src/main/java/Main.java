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
    private JTextField textField1;
    private JButton searchButtonLockScreen;
    private JButton searchButton01Background;
    private JPanel contentPanel;

    private ArrayList<String> imagesPaths;

    private Main() {
        imagesPaths = new ArrayList<String>();

       /* String path = "xd.png";
        try {
            BufferedImage picture = ImageFormatter.convertRGBAToIndexed(path);
            System.out.println(picture);

            ImageIO.write(picture, "png", new File("dest.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

       ActionListener srchAction = new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               JButton xd = (JButton) e.getSource();
               JTextField sap = (JTextField) xd.getParent().getComponent(0);
               System.out.println();

               JFileChooser chooser = new JFileChooser();
               FileNameExtensionFilter filter = new FileNameExtensionFilter("png files (*.png)", "png");
               chooser.setFileFilter(filter);
               int returnVal = chooser.showOpenDialog(panelMain);
               if(returnVal == JFileChooser.APPROVE_OPTION) {
                   System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                   String filePath = chooser.getSelectedFile().getAbsolutePath();
                   sap.setText(filePath);
                   imagesPaths.add(filePath);
               }

               /*

               /https://stackoverflow.com/questions/18774652/how-to-use-jfilechooser-to-find-a-file-location
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos gpx (*.gpx.xml)", "xml");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(panelMain);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                }
                txtRuta.setText(chooser.getSelectedFile().getName());
                mapa = chooser.getSelectedFile();

                */


           }
       };

       searchButtonLockScreen.addActionListener(srchAction);
       searchButton01Background.addActionListener(srchAction);

        buildButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Build button pressed");
                ArrayList<BufferedImage>  readyImages = new ArrayList<BufferedImage>();

                for(String path : imagesPaths) {
                    readyImages.add(ImageFormatter.convertRGBAToIndexed(path));
                }

                int number = 1;
                String finalNumber = "";

                for(BufferedImage image : readyImages) {
                    try {
                        if(number < 10) {
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
            }
        });
    }

    public static void main(String[] args) {
        //Get JAR LOCATION
        try {
            System.out.println(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("PsVita Theme Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Main().panelMain);
//        frame.setSize(450, 300);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
