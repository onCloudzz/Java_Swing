import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CharacterPanel extends JPanel {
    public CharacterPanel() {
        ImageIcon characterIcon = new ImageIcon("assets/char2.jpeg");
        Image characterImage = characterIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledCharacterIcon = new ImageIcon(characterImage);

        JLabel characterLabel = new JLabel(scaledCharacterIcon);
        characterLabel.setBorder(new LineBorder(Color.darkGray, 1, true));
        add(characterLabel);
    }
}
