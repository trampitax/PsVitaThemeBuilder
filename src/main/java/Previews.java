import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Previews {
    public JPanel mainPanel;
    private JTextField previewPath1;
    private JButton searchButton1;
    private JButton cancelButton;
    private JButton okButton;
    private JTextField previewPath2;
    private JButton searchButton2;
    private JTextField previewPath3;
    private JButton searchButton3;

    public static String [] previewsPath = {"", "", ""};

    public Previews() {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.previewsFrame.dispose();
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pathLockScreen = previewPath1.getText().trim();
                String pathPage = previewPath2.getText().trim();
                String pathThumbnail = previewPath3.getText().trim();

                if(!pathLockScreen.isEmpty()) {
                    previewsPath[0] = pathLockScreen;
                }

                if(!pathPage.isEmpty()) {
                    previewsPath[1] = pathPage;
                }

                if(!pathThumbnail.isEmpty()) {
                    previewsPath[2] = pathThumbnail;
                }

                System.out.println(previewsPath[0]);
                System.out.println(previewsPath[1]);
                System.out.println(previewsPath[2]);
                Main.previewsFrame.dispose();
            }
        });
        searchButton1.addActionListener(Main.srchAction);
        searchButton2.addActionListener(Main.srchAction);
        searchButton3.addActionListener(Main.srchAction);
    }
}
