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
        c.add(topPanel, BorderLayout.NORTH);

        c.add(weaponAndInventoryPanel, BorderLayout.SOUTH);

        //JSON Test
        //ItemRoomJson을 사용해 Room_Item의 정보 출력
        ItemRoomJson itemRoomJson = new ItemRoomJson();
        itemRoomJson.setInfo();
        System.out.println("RoomID : " + itemRoomJson.getRoomID());
        System.out.println("Background : " + itemRoomJson.getBackground());
        System.out.println("Event : " + itemRoomJson.getEvent());
        System.out.println("ItemsCount : " + itemRoomJson.getItemsCount());
        System.out.print("Item : ");
        for(int i = 0; i<itemRoomJson.getItemsCount();i++){
            System.out.print(itemRoomJson.getItem()[i] + " ");
        }
        System.out.println();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Start();
        });
    }
}
