import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;
import JSON.*;

public class Start extends JFrame {
    int [][] mapArray;
    int currentFloor;
    int currentRoom;
    int [] backpack;
    int backpackCategory;
    int stack;
    ImageIcon bgimg;
    JPanel bgPanel;
    JScrollPane scrollPane;
    MainStat mainStat;
    JLabel currentFloorLabel;
    JLabel moveUP;
    JLabel moveDOWN;
    JLabel moveRIGHT;
    JLabel moveLEFT;
    public Start() {
        setTitle("Project_Underworld");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1620, 900);
        Map map = new Map();
        Random rand = new Random();
        map.createMap(1,rand.nextInt());
        mapArray = map.getMap();
        currentFloor = 0;
        currentRoom = 0;
        mainStat = new MainStat();

        mainStat.GameData();
        mainStat.player.dataSet();
        mainStat.backpack.settingBackPack();
        RetJson retJson = new RetJson();
        //컨테이너 배경 이미지 설정
        bgimg = new ImageIcon("src/Resource/images/assets/bg_I1.jpg");
        JPanel bgPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(bgimg.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };




        StatusBars statusBars = new StatusBars();
        statusBars.setBounds(150, 50, 300, 75);

        CharacterPanel characterPanel = new CharacterPanel();
        characterPanel.setBounds(0, 0, 150, 150);
        MapPanel mapPanel = new MapPanel();
        mapPanel.setBounds(1300, 0, 300, 200);
        mapPanel.setLayout(new GridLayout(3,3));
        WeaponAndInventoryPanel weaponAndInventoryPanel = new WeaponAndInventoryPanel();
        weaponAndInventoryPanel.setBounds(550, 800, 500, 100);
        currentFloorLabel = new JLabel("Floor : " + mainStat.getFloor());
        currentFloorLabel.setBounds(1300,200,300,50);
        currentFloorLabel.setText("Floor : B" + (mainStat.getFloor()+1));
        currentFloorLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
        currentFloorLabel.setForeground(Color.white);
        bgPanel.add(currentFloorLabel);

        bgPanel.add(statusBars);
        bgPanel.add(characterPanel);

        bgPanel.add(mapPanel);

        bgPanel.add(weaponAndInventoryPanel);


        //BattleUI Panel


        mainStat.battleUI = new BattleUI();


        BackPackUI backPackUI = new BackPackUI(mainStat);
        backPackUI.setBounds(0,200,1600,600);
        bgPanel.add(mainStat.battleUI);
        bgPanel.add(backPackUI);
        backPackUI.setVisible(false);
        mainStat.battleUI.setVisible(false);

        moveUP = new JLabel("UP",SwingConstants.CENTER);
        moveUP.setBounds(775,50,50,50);
        moveUP.setBackground(Color.cyan);
        moveUP.setOpaque(true);
        moveUP.setBorder(BorderFactory.createLineBorder(Color.black));
        moveDOWN = new JLabel("DOWN",SwingConstants.CENTER);
        moveDOWN.setBounds(775,600,50,50);
        moveDOWN.setBackground(Color.cyan);
        moveDOWN.setOpaque(true);
        moveDOWN.setBorder(BorderFactory.createLineBorder(Color.black));
        moveRIGHT = new JLabel("RIGHT",SwingConstants.CENTER);
        moveRIGHT.setBounds(1400,350,50,50);
        moveRIGHT.setBackground(Color.cyan);
        moveRIGHT.setOpaque(true);
        moveRIGHT.setBorder(BorderFactory.createLineBorder(Color.black));
        moveLEFT = new JLabel("LEFT",SwingConstants.CENTER);
        moveLEFT.setBounds(200,350,50,50);
        moveLEFT.setBackground(Color.cyan);
        moveLEFT.setOpaque(true);
        moveLEFT.setBorder(BorderFactory.createLineBorder(Color.black));

        moveRIGHT.setVisible(true);
        moveUP.setVisible(false);
        moveDOWN.setVisible(false);
        moveLEFT.setVisible(false);

        ItemPanel itemPanel = new ItemPanel(mainStat,map,Start.this);
        itemPanel.setBounds(500,250,600,400);
        bgPanel.add(itemPanel);
        itemPanel.setVisible(true);
        moveUP.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(mainStat.getRoom() == 1){
                    if(mainStat.getFloor() > 0) {
                        mainStat.player.setFloor(mainStat.getFloor()-1);
                        System.out.println(mainStat.getFloor()+" "+mainStat.getRoom());
                        currentFloorLabel.setText("Floor : B" + (mainStat.getFloor()+1));
                        System.out.println(returnRoomID(mainStat.getFloor(),mainStat.getRoom()));
                        bgimg = new ImageIcon("src/Resource/images/assets/"+retJson.LoadJsonCollect(returnRoomID(mainStat.getFloor(),mainStat.getRoom()),"Background"));
                        //bgim resize
                        bgimg = new ImageIcon(bgimg.getImage().getScaledInstance(1600, 900, Image.SCALE_SMOOTH));
                        bgPanel.repaint();
                        if(returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==4||returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==3){
//                            mainStat.battleUI.setVisible(true);
//                            moveUP.setVisible(false);
//                            moveDOWN.setVisible(false);
//                            moveLEFT.setVisible(false);
//                            moveRIGHT.setVisible(false);

                        }else if(returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==1||returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==3) {
                            moveUP.setVisible(false);
                            moveDOWN.setVisible(false);
                            moveLEFT.setVisible(false);
                            moveRIGHT.setVisible(false);
                            itemPanel.ItemPanelAble(returnRoomID(mainStat.getFloor(),mainStat.getRoom()),Start.this);
                            System.out.println(returnRoomID(mainStat.getFloor(),mainStat.getRoom()));
                            itemPanel.setVisible(true);

                        }
                        if(mainStat.getRoom() != 1){
                            moveDOWN.setVisible(false);
                            moveUP.setVisible(false);
                        }
                        if(mainStat.getFloor() == 1){
                            moveDOWN.setVisible(true);
                            moveUP.setVisible(true);
                        }
                        if(mainStat.getFloor() == 0){
                            moveUP.setVisible(false);
                            moveDOWN.setVisible(true);
                        }
                        if(mainStat.getFloor() == 100){
                            moveUP.setVisible(false);
                            moveDOWN.setVisible(false);
                            moveLEFT.setVisible(false);
                            moveRIGHT.setVisible(false);
                        }
                        if(mainStat.getRoom() == 1){
                            moveRIGHT.setVisible(true);
                            moveLEFT.setVisible(true);
                        }
                        if(mainStat.getRoom() == 0){
                            moveLEFT.setVisible(false);
                            moveRIGHT.setVisible(true);
                            moveDOWN.setVisible(false);
                            moveUP.setVisible(false);
                        }
                        if(mainStat.getRoom() == 2){
                            moveLEFT.setVisible(true);
                            moveRIGHT.setVisible(false);
                            moveDOWN.setVisible(false);
                            moveUP.setVisible(false);
                        }
                        mapPanel.setMap(mapArray, mainStat.getFloor(), mainStat.getRoom());
                    }
                }
            }
        });
        moveDOWN.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(mainStat.getRoom() == 1){
                    if(mainStat.getFloor() < 100) {
                        mainStat.player.setFloor(mainStat.getFloor()+1);
                        System.out.println(mainStat.getFloor()+" "+mainStat.getRoom());
                        currentFloorLabel.setText("Floor : B" + (mainStat.getFloor()+1));
                        System.out.println(returnRoomID(mainStat.getFloor(),mainStat.getRoom()));
                        bgimg = new ImageIcon("src/Resource/images/assets/"+retJson.LoadJsonCollect(returnRoomID(mainStat.getFloor(),mainStat.getRoom()),"Background"));
                        //bgim resize
                        bgimg = new ImageIcon(bgimg.getImage().getScaledInstance(1600, 900, Image.SCALE_SMOOTH));
                        bgPanel.repaint();
                        if(returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==4||returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==3){
//                            mainStat.battleUI.setVisible(true);
//                            moveUP.setVisible(false);
//                            moveDOWN.setVisible(false);
//                            moveLEFT.setVisible(false);
//                            moveRIGHT.setVisible(false);

                        }else if(returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==1||returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==3) {
                            moveUP.setVisible(false);
                            moveDOWN.setVisible(false);
                            moveLEFT.setVisible(false);
                            moveRIGHT.setVisible(false);
                            itemPanel.ItemPanelAble(returnRoomID(mainStat.getFloor(),mainStat.getRoom()),Start.this);
                            System.out.println(returnRoomID(mainStat.getFloor(),mainStat.getRoom()));
                            itemPanel.setVisible(true);

                        }
                        if(mainStat.getRoom() != 1){
                            moveDOWN.setVisible(false);
                            moveUP.setVisible(false);
                        }
                        if(mainStat.getFloor() == 1){
                            moveDOWN.setVisible(true);
                            moveUP.setVisible(true);
                        }
                        if(mainStat.getFloor() == 0){
                            moveUP.setVisible(false);
                            moveDOWN.setVisible(true);
                        }
                        if(mainStat.getFloor() == 100){
                            moveUP.setVisible(false);
                            moveDOWN.setVisible(false);
                            moveLEFT.setVisible(false);
                            moveRIGHT.setVisible(false);
                        }
                        if(mainStat.getRoom() == 1){
                            moveRIGHT.setVisible(true);
                            moveLEFT.setVisible(true);
                        }
                        if(mainStat.getRoom() == 0){
                            moveLEFT.setVisible(false);
                            moveRIGHT.setVisible(true);
                            moveDOWN.setVisible(false);
                            moveUP.setVisible(false);
                        }
                        if(mainStat.getRoom() == 2){
                            moveLEFT.setVisible(true);
                            moveRIGHT.setVisible(false);
                            moveDOWN.setVisible(false);
                            moveUP.setVisible(false);
                        }
                        mapPanel.setMap(mapArray, mainStat.getFloor(), mainStat.getRoom());
                    }
                }
            }
        });

        moveLEFT.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                    if(mainStat.getRoom() > 0) {
                        mainStat.player.setRoom(mainStat.getRoom()-1);
                        System.out.println(mainStat.getFloor()+" "+mainStat.getRoom());
                        currentFloorLabel.setText("Floor : B" + (mainStat.getFloor()+1));
                        System.out.println(returnRoomID(mainStat.getFloor(),mainStat.getRoom()));
                        bgimg = new ImageIcon("src/Resource/images/assets/"+retJson.LoadJsonCollect(returnRoomID(mainStat.getFloor(),mainStat.getRoom()),"Background"));
                        //bgim resize
                        bgimg = new ImageIcon(bgimg.getImage().getScaledInstance(1620, 900, Image.SCALE_SMOOTH));
                        bgPanel.repaint();
                        if(returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==4||returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==3){
//                            mainStat.battleUI.setVisible(true);
//                            moveUP.setVisible(false);
//                            moveDOWN.setVisible(false);
//                            moveLEFT.setVisible(false);
//                            moveRIGHT.setVisible(false);

                        }else if(returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==1||returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==3) {
                            moveUP.setVisible(false);
                            moveDOWN.setVisible(false);
                            moveLEFT.setVisible(false);
                            moveRIGHT.setVisible(false);
                            itemPanel.ItemPanelAble(returnRoomID(mainStat.getFloor(),mainStat.getRoom()),Start.this);
                            System.out.println(returnRoomID(mainStat.getFloor(),mainStat.getRoom()));
                            itemPanel.setVisible(true);

                        }
                        if(mainStat.getRoom() != 1){
                            moveDOWN.setVisible(false);
                            moveUP.setVisible(false);
                        }
                        if(mainStat.getRoom() == 1){
                            moveDOWN.setVisible(true);
                            moveUP.setVisible(true);
                        }
                        if(mainStat.getFloor() == 0){
                            moveUP.setVisible(false);
                            moveDOWN.setVisible(true);
                        }
                        if(mainStat.getFloor() == 100){
                            moveUP.setVisible(false);
                            moveDOWN.setVisible(false);
                            moveLEFT.setVisible(false);
                            moveRIGHT.setVisible(false);
                        }
                        if(mainStat.getRoom() == 1){
                            moveRIGHT.setVisible(true);
                            moveLEFT.setVisible(true);
                        }
                        if(mainStat.getRoom() == 0){
                            moveLEFT.setVisible(false);
                            moveRIGHT.setVisible(true);
                            moveDOWN.setVisible(false);
                            moveUP.setVisible(false);
                        }
                        if(mainStat.getRoom() == 2){
                            moveLEFT.setVisible(true);
                            moveRIGHT.setVisible(false);
                            moveDOWN.setVisible(false);
                            moveUP.setVisible(false);
                        }
                        mapPanel.setMap(mapArray, mainStat.getFloor(), mainStat.getRoom());
                    }

            }
        });

        moveRIGHT.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                    if(mainStat.getRoom() < 2) {
                        mainStat.player.setRoom(mainStat.getRoom()+1);
                        System.out.println(mainStat.getFloor()+" "+mainStat.getRoom());
                        currentFloorLabel.setText("Floor : B" + (mainStat.getFloor()+1));
                        System.out.println(returnRoomID(mainStat.getFloor(),mainStat.getRoom()));
                        bgimg = new ImageIcon("src/Resource/images/assets/"+retJson.LoadJsonCollect(returnRoomID(mainStat.getFloor(),mainStat.getRoom()),"Background"));
                        //bgim resize
                        bgimg = new ImageIcon(bgimg.getImage().getScaledInstance(1620, 900, Image.SCALE_SMOOTH));
                        bgPanel.repaint();
                        if(returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==4||returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==3){
//                            mainStat.battleUI.setVisible(true);
//                            moveUP.setVisible(false);
//                            moveDOWN.setVisible(false);
//                            moveLEFT.setVisible(false);
//                            moveRIGHT.setVisible(false);

                        }else if(returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==1||returnRoomID(mainStat.getFloor(),mainStat.getRoom())/1000==3) {
                            moveUP.setVisible(false);
                            moveDOWN.setVisible(false);
                            moveLEFT.setVisible(false);
                            moveRIGHT.setVisible(false);
                            itemPanel.ItemPanelAble(returnRoomID(mainStat.getFloor(),mainStat.getRoom()),Start.this);
                            System.out.println(returnRoomID(mainStat.getFloor(),mainStat.getRoom()));
                            itemPanel.setVisible(true);

                        }
                        if(mainStat.getRoom() != 1){
                            moveDOWN.setVisible(false);
                            moveUP.setVisible(false);
                        }
                        if(mainStat.getRoom() == 1){
                            moveDOWN.setVisible(true);
                            moveUP.setVisible(true);
                        }
                        if(mainStat.getFloor() == 0){
                            moveUP.setVisible(false);
                            moveDOWN.setVisible(true);
                        }
                        if(mainStat.getFloor() == 100){
                            moveUP.setVisible(false);
                            moveDOWN.setVisible(false);
                            moveLEFT.setVisible(false);
                            moveRIGHT.setVisible(false);
                        }
                        if(mainStat.getRoom() == 1){
                            moveRIGHT.setVisible(true);
                            moveLEFT.setVisible(true);
                        }
                        if(mainStat.getRoom() == 0){
                            moveLEFT.setVisible(false);
                            moveRIGHT.setVisible(true);
                            moveDOWN.setVisible(false);
                            moveUP.setVisible(false);
                        }
                        if(mainStat.getRoom() == 2){
                            moveLEFT.setVisible(true);
                            moveRIGHT.setVisible(false);
                            moveDOWN.setVisible(false);
                            moveUP.setVisible(false);
                        }
                        mapPanel.setMap(mapArray, mainStat.getFloor(), mainStat.getRoom());
                    }

            }
        });


        bgPanel.add(moveUP);
        bgPanel.add(moveDOWN);
        bgPanel.add(moveLEFT);
        bgPanel.add(moveRIGHT);

        backpackCategory = 0;
        weaponAndInventoryPanel.inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(backPackUI.isVisible()){
                    backPackUI.setVisible(false);
                }else{
                    backPackUI.setVisible(true);

                }

            }

        });



        mapPanel.setMap(mapArray, 0, 0);
        while(true) {
            break;
        }
        Container c = getContentPane();
        bgPanel.setLayout(null);


        scrollPane = new JScrollPane(bgPanel);
        setContentPane(scrollPane);

        setVisible(true);
    }
    public void backpackLoad() {
        BackPack backPack = new BackPack();

    }
    public int returnRoomID(int currentFloor, int currentRoom){
        return mapArray[currentFloor][currentRoom];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Start();
        });
    }
}
