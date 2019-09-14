import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Info {
    public JPanel mainPanel;
    private JLabel infoLabel;
    private JTextArea textArea1;

    Info() {
        textArea1.setText("The program only needs four fields to create a theme.\n" +
                "Those fields are the ones you see when you open the program:\n" +
                "    - Theme Title\n" +
                "    - Author Name\n" +
                "    - LockScreen Image Path\n" +
                "    - Page 1 Background Image Path\n\n" +
                "All the other files are totally optional. This program can build the theme withouth them.\n" +
                "The program also have colors predefined, but you can change them opening the 'Misc.' window.\n\n" +
                "--- IMPORTANT ---\n" +
                "If you saw a dialog saying that at9tool.exe wasn't found, don't worry. That program it's not necessary" +
                "but you'll need it if you want to convert .wav files to .at9 formats.");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.setEditable(false);
        textArea1.setFont(textArea1.getFont().deriveFont(15f));

        infoLabel.setText("<html><a href=''>https://github.com/trampitax/PsVitaThemeBuilder</a></html>");
        infoLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        infoLabel.setFont(infoLabel.getFont().deriveFont(15f));
        infoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/trampitax/PsVitaThemeBuilder"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
