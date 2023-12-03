import javax.swing.*;
import java.awt.*;

public class WeaponAndInventoryPanel extends JPanel {
    JButton inventoryButton ;
    public WeaponAndInventoryPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER));

        // Current weapon bar (Placeholder)
        JLabel currentWeaponLabel = new JLabel("Current Weapon:");
        currentWeaponLabel.setBackground(Color.gray);
        currentWeaponLabel.setOpaque(true);
        currentWeaponLabel.setSize(500, 150);
        add(currentWeaponLabel);

        // Inventory button
        inventoryButton = new JButton();
        ImageIcon backpackIcon = new ImageIcon("src/Resource/images/assets/backpack.jpeg");
        Image backpackImage = backpackIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(backpackImage);
        inventoryButton.setIcon(scaledIcon);
        add(inventoryButton);
    }
}
