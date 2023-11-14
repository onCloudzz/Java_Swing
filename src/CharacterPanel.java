import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class CharacterPanel extends JPanel {
    public CharacterPanel() {
        setLayout(new BorderLayout());

        ImageIcon characterIcon = new ImageIcon("assets/gunslinger.jpg");
        Image characterImage = characterIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledCharacterIcon = new ImageIcon(characterImage);

        JLabel characterLabel = new JLabel(scaledCharacterIcon);
        add(characterLabel, BorderLayout.WEST);
    }
}
