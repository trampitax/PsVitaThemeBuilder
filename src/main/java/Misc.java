import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Misc {
    public JPanel mainPanel;
    private JTextField ff8ec7e9TextField;
    private JTextField ff000000TextField;
    private JTextField textField3;
    private JButton srchButton1;
    private JTextField textField4;
    private JTextField textField5;
    private JButton srchButton2;
    private JButton srchButton3;
    private JTextField ffe4cfb1TextField;
    private JButton okButton;
    private JButton cancelButton;
    private JTextField a0TextField;
    private JTextField ffffffffTextField;
    private JTextField a1fffffffTextField;
    private JTextField ffccccccTextField;
    private JPanel lockScreenPanel;
    private JPanel statusBarPanel;
    private JPanel iconsPanel;

    public static String [] miscList = {"", "", "", "", "", "", "", "", "", ""};

    public Misc() {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.miscFrame.dispose();
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Icons
                for(int i = 0; i <= 2; i++) {
                    JTextField path = (JTextField) iconsPanel.getAccessibleContext().getAccessibleChild(i).getAccessibleContext().getAccessibleChild(0);
                    if(!path.getText().trim().isEmpty()) {
                        miscList[i] = path.getText().trim();
                    }
                }

                // Status Bar
                JTextField field = (JTextField) statusBarPanel.getAccessibleContext().getAccessibleChild(2);
                if(!field.getText().trim().isEmpty()) {
                    miscList[3] = field.getText().trim();
                }
                field = (JTextField) statusBarPanel.getAccessibleContext().getAccessibleChild(3);
                if(!field.getText().trim().isEmpty()) {
                    miscList[4] = field.getText().trim();
                }

                // Lock Screen
                int x = 0;
                int lockscreenCounter = 5;
                while(lockScreenPanel.getAccessibleContext().getAccessibleChild(x) != null) {
                    if(lockScreenPanel.getAccessibleContext().getAccessibleChild(x).getClass().getName().equalsIgnoreCase("javax.swing.JTextField")) {
                        JTextField textField = (JTextField) lockScreenPanel.getAccessibleContext().getAccessibleChild(x);
                        if(!textField.getText().trim().isEmpty()) {
                            miscList[lockscreenCounter] = textField.getText().trim();
                            lockscreenCounter++;
                        }
                    }
                    x++;
                }
                Main.miscFrame.dispose();
            }
        });
        srchButton1.addActionListener(Main.srchAction);
        srchButton2.addActionListener(Main.srchAction);
        srchButton3.addActionListener(Main.srchAction);
    }
}
