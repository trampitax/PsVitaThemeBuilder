import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Audio {
    public JPanel mainPanel;
    private JTextField pathTxt;
    private JButton searchButton;
    private JButton okButton;
    private JButton cancelButton;

    public static String wavFilePath= "";

    public Audio() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempPath = pathTxt.getText().trim();
                if(!tempPath.isEmpty()) {
                    wavFilePath = tempPath;
                }

                Main.audioFrame.dispose();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("wav audio file (*.wav)", "wav");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(mainPanel);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                    String filePath = chooser.getSelectedFile().getAbsolutePath();
                    pathTxt.setText(filePath);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.audioFrame.dispose();
            }
        });
    }
}
