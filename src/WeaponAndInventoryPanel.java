import javax.swing.*;
import java.awt.*;

public class WeaponAndInventoryPanel extends JPanel {
    public WeaponAndInventoryPanel() {
        setLayout(new BorderLayout());

        // Current weapon bar (Placeholder)
        JLabel currentWeaponLabel = new JLabel("Current Weapon:");
        add(currentWeaponLabel, BorderLayout.CENTER);

        // Inventory button
        JButton inventoryButton = new JButton("Inventory");
        add(inventoryButton, BorderLayout.EAST);
    }
}