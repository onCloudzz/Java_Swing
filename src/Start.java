import java.awt.*;
import javax.swing.*;

public class Start extends JFrame {
    public Start() {
        setTitle("Main Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 900);

        StatusBars statusBars = new StatusBars();
        CharacterPanel characterPanel = new CharacterPanel();
        MapPanel mapPanel = new MapPanel();
        WeaponAndInventoryPanel weaponAndInventoryPanel = new WeaponAndInventoryPanel();

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        // Top panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(characterPanel, BorderLayout.WEST);
        topPanel.add(statusBars, BorderLayout.CENTER);
        topPanel.add(mapPanel, BorderLayout.EAST);
        c.add(topPanel, BorderLayout.NORTH);


        JPanel bottomPanel = new JPanel();
        bottomPanel.add(weaponAndInventoryPanel);
        c.add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Start();
        });
    }
}
