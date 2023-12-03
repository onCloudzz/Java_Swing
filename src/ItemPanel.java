import JSON.RetJson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class ItemPanel extends JPanel {
    Map map;
    MainStat mainStat;
    JLabel[] itemNameLabel;
    JLabel[] itemIDLabel;
    RetJson retJson;
    int [] itemIDArr;
    int [][] mapArray;
    JPanel itemsPanel;
    JPanel[] itemPanel;
    int remainItem;
    public ItemPanel(MainStat mainStat,Map map,Start start){

        setLayout(null);
        this.mainStat = mainStat;
        this.map = map;
        mapArray = map.getMap();

        JButton exit = new JButton("X");

        itemsPanel = new JPanel();
        itemsPanel.repaint();
        itemsPanel.setLayout(new GridLayout(2,2));
        itemsPanel.setBounds(100,50,400,300);
        itemsPanel.setBackground(Color.gray);
        ItemPanelAble(mapArray[mainStat.getFloor()][mainStat.getRoom()],start);
        add(itemsPanel);

        exit.setBounds(580,0,20,20);
        exit.setBackground(Color.red);
        exit.setVisible(true);
        exit.addActionListener(e -> {
            setVisible(false);
            map.MapEdit(mainStat.getFloor(),mainStat.getRoom(),1000);
            if(mainStat.getRoom() != 1){
                start.moveDOWN.setVisible(false);
                start.moveUP.setVisible(false);
            }
            if(mainStat.getRoom() == 1){
                start.moveDOWN.setVisible(true);
                start.moveUP.setVisible(true);
                start.moveRIGHT.setVisible(true);
                start. moveLEFT.setVisible(true);
            }
            if(mainStat.getFloor() == 0){
                start.moveUP.setVisible(false);
                start.moveDOWN.setVisible(true);
            }
            if(mainStat.getFloor() == 100){
                start.moveUP.setVisible(false);
                start.moveDOWN.setVisible(false);
                start.moveLEFT.setVisible(false);
                start.moveRIGHT.setVisible(false);
            }
            if(mainStat.getRoom() == 0){
                start.moveLEFT.setVisible(false);
                start.moveRIGHT.setVisible(true);
                start.moveDOWN.setVisible(false);
                start.moveUP.setVisible(false);
            }
            if(mainStat.getRoom() == 2){
                start.moveLEFT.setVisible(true);
                start.moveRIGHT.setVisible(false);
                start.moveDOWN.setVisible(false);
                start.moveUP.setVisible(false);
            }
        });
        add(exit);
        setBounds(300, 0, 1000, 700);
        setBackground(Color.LIGHT_GRAY);
    }
    public void ItemPanelAble(int RoomID,Start start){
        retJson = new RetJson();
        int Event = Integer.parseInt(retJson.LoadJsonCollect(RoomID,"Event"));
        int ItemsCount = Integer.parseInt(retJson.LoadJsonCollect(RoomID,"ItemsCount"));
        itemIDArr = new int[ItemsCount];
        for(int i = 0; i<ItemsCount;i++){
            if(i == 0)
                if(Event == 0) {
                    int random = getRandomItem(0);
                    System.out.println(random);
                    itemIDArr[i] = random;
                }
                else {
                    int random = getRandomItem(0);
                    System.out.println(random);
                    System.out.println(ItemsCount);
                    System.out.println(itemIDArr[i]);
                    itemIDArr[i] = random;
                }
            else {
                int random = getRandomItem(0);
                System.out.println(random);
                itemIDArr[i] = random;
            }
        }

        remainItem = ItemsCount;
        if(remainItem == 0)
        {
            setVisible(false);
            map.MapEdit(mainStat.getFloor(),mainStat.getRoom(),1000);
            if(mainStat.getRoom() != 1){
                start.moveDOWN.setVisible(false);
                start.moveUP.setVisible(false);
            }
            if(mainStat.getRoom() == 1){
                start.moveDOWN.setVisible(true);
                start.moveUP.setVisible(true);
                start.moveRIGHT.setVisible(true);
                start. moveLEFT.setVisible(true);
            }
            if(mainStat.getFloor() == 0){
                start.moveUP.setVisible(false);
                start.moveDOWN.setVisible(true);
            }
            if(mainStat.getFloor() == 100){
                start.moveUP.setVisible(false);
                start.moveDOWN.setVisible(false);
                start.moveLEFT.setVisible(false);
                start.moveRIGHT.setVisible(false);
            }
            if(mainStat.getRoom() == 0){
                start.moveLEFT.setVisible(false);
                start.moveRIGHT.setVisible(true);
                start.moveDOWN.setVisible(false);
                start.moveUP.setVisible(false);
            }
            if(mainStat.getRoom() == 2){
                start.moveLEFT.setVisible(true);
                start.moveRIGHT.setVisible(false);
                start.moveDOWN.setVisible(false);
                start.moveUP.setVisible(false);
            }
        }
        itemNameLabel = new JLabel[4];
        itemIDLabel = new JLabel[4];
        itemPanel = new JPanel[4];


        for(int i = 0; i<ItemsCount;i++){
            itemPanel[i] = new JPanel();
            itemPanel[i].repaint();
            itemPanel[i].setLayout(new GridLayout(2,1));
            itemNameLabel[i] = new JLabel();
            itemIDLabel[i] = new JLabel();
            itemNameLabel[i].setText(retJson.LoadJsonCollect(itemIDArr[i],"Name"));
            itemIDLabel[i].setText(Integer.toString(itemIDArr[i]));
            itemPanel[i].add(itemNameLabel[i]);
            itemPanel[i].add(itemIDLabel[i]);
            itemPanel[i].setBackground(Color.white);
            itemPanel[i].setBorder(BorderFactory.createLineBorder(Color.black));
            int finalI = i;
            itemPanel[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    mainStat.backpack.addBackPack(Integer.parseInt(itemIDLabel[finalI].getText()));
                    itemPanel[finalI].setVisible(false);
                    itemsPanel.remove(itemPanel[finalI]);
                    remainItem--;
                    System.out.println(remainItem);
                    if(remainItem == 0){
                        setVisible(false);
                        map.MapEdit(mainStat.getFloor(),mainStat.getRoom(),1000);
                        if(mainStat.getRoom() != 1){
                            start.moveDOWN.setVisible(false);
                            start.moveUP.setVisible(false);
                        }
                        if(mainStat.getRoom() == 1){
                            start.moveDOWN.setVisible(true);
                            start.moveUP.setVisible(true);
                            start.moveRIGHT.setVisible(true);
                            start. moveLEFT.setVisible(true);
                        }
                        if(mainStat.getFloor() == 0){
                            start.moveUP.setVisible(false);
                            start.moveDOWN.setVisible(true);
                        }
                        if(mainStat.getFloor() == 100){
                            start.moveUP.setVisible(false);
                            start.moveDOWN.setVisible(false);
                            start.moveLEFT.setVisible(false);
                            start.moveRIGHT.setVisible(false);
                        }
                        if(mainStat.getRoom() == 0){
                            start.moveLEFT.setVisible(false);
                            start.moveRIGHT.setVisible(true);
                            start.moveDOWN.setVisible(false);
                            start.moveUP.setVisible(false);
                        }
                        if(mainStat.getRoom() == 2){
                            start.moveLEFT.setVisible(true);
                            start.moveRIGHT.setVisible(false);
                            start.moveDOWN.setVisible(false);
                            start.moveUP.setVisible(false);
                        }
                    }
                }
            });
            itemsPanel.add(itemPanel[i]);
        }
    }
    public int getRandomItem(int event){
        Random random = new Random();
        int randomItem = random.nextInt(6)+1;
        if(event == 0) {
            return switch (randomItem) {
                case 1, 2 -> random.nextInt(4) + 10;
                case 3 -> random.nextInt(2) + 30;
                case 4, 5, 6 -> random.nextInt(6) + 50;
                default -> 0;
            };
        }else {
            return switch (randomItem) {
                case 1, 2 -> random.nextInt(7) + 10;
                case 3 -> random.nextInt(3) + 30;
                case 4, 5, 6 -> random.nextInt(9) + 50;
                default -> 0;
            };
        }
    }
}
