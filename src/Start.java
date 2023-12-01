import java.awt.*;
import javax.swing.*;
import JSON.*;

public class Start extends JFrame {
    public Start() {
        setTitle("Project_Underworld");
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
        JPanel topLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topLeftPanel.add(characterPanel);
        topLeftPanel.add(statusBars);

        topPanel.add(topLeftPanel, BorderLayout.WEST);
        topPanel.add(mapPanel, BorderLayout.EAST);
  
        c.add(weaponAndInventoryPanel, BorderLayout.SOUTH);


        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Start();
            Map map = new Map();
            map.createMap(1,123);
        });
    }
}
