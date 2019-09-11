import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Icons {
    public JPanel mainPanel;
    private JButton cancelButton;
    private JButton okButton;
    private JPanel iconsPanel;
    private JPanel row1;
    private JPanel row2;
    private JPanel row3;
    private JPanel row4;
    private JPanel row5;
    private JPanel row6;
    private JPanel row7;
    private JPanel row8;
    private JPanel row9;
    private JTextField textField1;
    private JButton srchBtn1;
    private JTextField textField2;
    private JButton srchBtn2;
    private JTextField textField3;
    private JButton srchBtn3;
    private JTextField textField4;
    private JButton srchBtn4;
    private JTextField textField5;
    private JButton srchBtn5;
    private JTextField textField6;
    private JButton srchBtn6;
    private JTextField textField7;
    private JButton srchBtn7;
    private JTextField textField8;
    private JButton srchBtn8;
    private JTextField textField9;
    private JButton srchBtn9;
    private JTextField textField10;
    private JButton srchBtn10;
    private JTextField textField11;
    private JButton srchBtn11;
    private JTextField textField12;
    private JButton srchBtn12;
    private JTextField textField13;
    private JButton srchBtn13;
    private JTextField textField14;
    private JButton srchBtn14;
    private JTextField textField15;
    private JButton srchBtn15;
    private JTextField textField16;
    private JButton srchBtn16;
    private JTextField textField17;
    private JButton srchBtn17;

    public static String [] iconsPath = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    public Icons() {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.iconsFrame.dispose();
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String calendarPath = textField1.getText().trim();
                String contentManagerAssistantPath = textField2.getText().trim();
                String friendsPath = textField3.getText().trim();
                String mailPath = textField4.getText().trim();
                String messagesPath = textField5.getText().trim();
                String musicPath = textField6.getText().trim();
                String nearPath = textField7.getText().trim();
                String parentalPath = textField8.getText().trim();
                String partyPath = textField9.getText().trim();
                String photosPath = textField10.getText().trim();
                String powerPath = textField11.getText().trim();
                String ps3Path = textField12.getText().trim();
                String ps4Path = textField13.getText().trim();
                String settingsPath = textField14.getText().trim();
                String trophiesPath = textField15.getText().trim();
                String videosPath = textField16.getText().trim();
                String webPath = textField17.getText().trim();

                if(!calendarPath.isEmpty()) {
                    iconsPath[0] = calendarPath;
                }
                if(!contentManagerAssistantPath.isEmpty()) {
                    iconsPath[1] = contentManagerAssistantPath;
                }
                if(!friendsPath.isEmpty()) {
                    iconsPath[2] = friendsPath;
                }
                if(!mailPath.isEmpty()) {
                    iconsPath[3] = mailPath;
                }
                if(!messagesPath.isEmpty()) {
                    iconsPath[4] = messagesPath;
                }
                if(!musicPath.isEmpty()) {
                    iconsPath[5] = musicPath;
                }
                if(!nearPath.isEmpty()) {
                    iconsPath[6] = nearPath;
                }
                if(!parentalPath.isEmpty()) {
                    iconsPath[7] = parentalPath;
                }
                if(!partyPath.isEmpty()) {
                    iconsPath[8] = partyPath;
                }
                if(!photosPath.isEmpty()) {
                    iconsPath[9] = photosPath;
                }
                if(!powerPath.isEmpty()) {
                    iconsPath[10] = powerPath;
                }
                if(!ps3Path.isEmpty()) {
                    iconsPath[11] = ps3Path;
                }
                if(!ps4Path.isEmpty()) {
                    iconsPath[12] = ps4Path;
                }
                if(!settingsPath.isEmpty()) {
                    iconsPath[13] = settingsPath;
                }
                if(!trophiesPath.isEmpty()) {
                    iconsPath[14] = trophiesPath;
                }
                if(!videosPath.isEmpty()) {
                    iconsPath[15] = videosPath;
                }
                if(!webPath.isEmpty()) {
                    iconsPath[16] = webPath;
                }

                Main.iconsFrame.dispose();
            }
        });
        srchBtn1.addActionListener(Main.srchAction);
        srchBtn2.addActionListener(Main.srchAction);
        srchBtn3.addActionListener(Main.srchAction);
        srchBtn4.addActionListener(Main.srchAction);
        srchBtn5.addActionListener(Main.srchAction);
        srchBtn6.addActionListener(Main.srchAction);
        srchBtn7.addActionListener(Main.srchAction);
        srchBtn8.addActionListener(Main.srchAction);
        srchBtn9.addActionListener(Main.srchAction);
        srchBtn10.addActionListener(Main.srchAction);
        srchBtn11.addActionListener(Main.srchAction);
        srchBtn12.addActionListener(Main.srchAction);
        srchBtn13.addActionListener(Main.srchAction);
        srchBtn14.addActionListener(Main.srchAction);
        srchBtn15.addActionListener(Main.srchAction);
        srchBtn16.addActionListener(Main.srchAction);
        srchBtn17.addActionListener(Main.srchAction);
    }
}
