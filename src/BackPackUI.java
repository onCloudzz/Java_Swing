import JSON.RetJson;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class BackPackUI extends JPanel {
    private int currentmenu;

    MainStat mainStat;
    RetJson retJson;

    private int[] weaponinventory;
    private int[] armorinventory;
    private int[] foodinventory;
    private int[] category;
    private int backCategory;
    JLabel[] weaponLabel;
    JLabel[] armorLabel;
    JLabel[] foodLabel ;

    JLabel[] tabLabel;
    
    int i;
    
    int selectedWeapon = -1 ;
    public BackPackUI(MainStat mainStat)
    {
        setLayout(null);
        this.mainStat = mainStat;
        retJson = new RetJson();
        BackPack bp = mainStat.backpack;

        weaponinventory = bp.getWeaponInventory();
        armorinventory = bp.getArmorInventory();
        foodinventory = bp.getFoodInventory();

        JPanel weaponbackPackPanel = new JPanel();
        weaponbackPackPanel.setLayout(new GridLayout(3,6));
        weaponbackPackPanel.setBounds(30,30,1200,398);
        JPanel armorbackPackPanel = new JPanel();
        armorbackPackPanel.setLayout(new GridLayout(3,6));
        armorbackPackPanel.setBounds(30,30,1200,398);
        JPanel foodbackPackPanel = new JPanel();
        foodbackPackPanel.setLayout(new GridLayout(3,6));
        foodbackPackPanel.setBounds(30,30,1200,398);
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(null);
        descriptionPanel.setBounds(1260,30,300,530);
        JPanel backPacktabPanel = new JPanel();
        backPacktabPanel.setLayout(new GridLayout(1,3));
        backPacktabPanel.setBounds(30,428,1200,132);

        JLabel descriptionLabel = new JLabel();
        descriptionLabel.setBounds(0,0,300,530);
        descriptionLabel.setBackground(Color.gray);
        descriptionLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
        descriptionPanel.add(descriptionLabel);

        add(weaponbackPackPanel);
        add(armorbackPackPanel);
        add(foodbackPackPanel);
        add(descriptionPanel);
        add(backPacktabPanel);

        weaponLabel = new JLabel[24];
        armorLabel = new JLabel[24];
        foodLabel = new JLabel[24];

        tabLabel = new JLabel[3];


        for(i = 0; i < 18; i++) {
            weaponLabel[i] = new JLabel("");
            armorLabel[i] = new JLabel("");
            foodLabel[i] = new JLabel("");
            weaponbackPackPanel.add(weaponLabel[i]);
            armorbackPackPanel.add(armorLabel[i]);
            foodbackPackPanel.add(foodLabel[i]);
        }
        for(i = 0; i< 3;i++){
            tabLabel[i] = new JLabel("",SwingConstants.CENTER);
            int FinalI = i;
            tabLabel[i].setBorder(BorderFactory.createLineBorder(Color.orange));
            tabLabel[i].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);

                }
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    tabLabel[FinalI].setBorder(BorderFactory.createLineBorder(Color.red));
                    //bp 에서 무기, 방어구, 음식 목록 출력
                    int [] arr = armorinventory;
                    int [] arr2 = weaponinventory;
                    int [] arr3 = foodinventory;
                    for(int i = 0; i < bp.getArmorstack(); i++){
                        if(armorinventory[i]!=0) {
                            String armorName = retJson.LoadJsonCollect(armorinventory[i], "Name");
                            armorLabel[i].setText(armorName);
                        }
                        else{
                            armorLabel[i].setText("Empty");
                        }
                    }
                    for(int i = 0; i < bp.getWeaponstack(); i++){
                        if(weaponinventory[i]!=0) {
                            String weaponName = retJson.LoadJsonCollect(bp.getWeaponInventory()[i], "Name");
                            weaponLabel[i].setText(weaponName);
                        }
                        else{
                            weaponLabel[i].setText("Empty");
                        }
                    }
                    for(int i = 0; i < bp.getFoodstack(); i++){
                        if(foodinventory[i]!=0) {
                            String foodName = retJson.LoadJsonCollect(foodinventory[i], "Name");
                            foodLabel[i].setText(foodName);
                        }
                        else{
                            foodLabel[i].setText("Empty");
                        }
                    }

                    if(FinalI == 0) {
                            foodbackPackPanel.setVisible(false);
                            armorbackPackPanel.setVisible(false);
                            weaponbackPackPanel.setVisible(true);

                    }
                    else if(FinalI == 1) {
                            weaponbackPackPanel.setVisible(false);
                            foodbackPackPanel.setVisible(false);
                            armorbackPackPanel.setVisible(true);
                    }
                    else if(FinalI == 2) {
                            weaponbackPackPanel.setVisible(false);
                            armorbackPackPanel.setVisible(false);
                            foodbackPackPanel.setVisible(true);
                    }


                    for(int j = 0; j < 3; j++){
                        if(j != FinalI){
                            tabLabel[j].setBorder(BorderFactory.createLineBorder(Color.orange));
                        }
                    }

                }
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);

                }

            });
            backPacktabPanel.add(tabLabel[i]);

        }
        tabLabel[0].setText("Weapon");
        tabLabel[0].setFont(new Font("Open Sans", Font.BOLD, 20));
        tabLabel[1].setText("Armor");
        tabLabel[1].setFont(new Font("Open Sans", Font.BOLD, 20));
        tabLabel[2].setText("Food");
        tabLabel[2].setFont(new Font("Open Sans", Font.BOLD, 20));




        for(i = 0; i < 18; i++){
            int FinalI = i;
            weaponLabel[i].setBorder(BorderFactory.createLineBorder(Color.white));
//            weaponLabel[i].setIcon(new ImageIcon("Resource/images/" + weaponinventory[i] + ".png"));
            weaponLabel[i].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    /*
                    {
  "WeaponID" : 11,
  "WeaponName" : "Punch",
  "damage" : 2,
  "accuracy" : 10,
  "durability" : 10
}
                    */
                    if(bp.searchWeapon(i)==0){
                        descriptionLabel.setText("Empty");
                    }else {
                        descriptionLabel.setText("WeaponName :" + retJson.LoadJsonCollect(bp.searchWeapon(i), "Name") + "\n" +
                                "Damage :" + retJson.LoadJsonCollect(bp.searchWeapon(i), "Damage") + "\n" +
                                "Accuracy :" + retJson.LoadJsonCollect(bp.searchWeapon(i), "Accuracy") + "\n" +
                                "Durability :" + retJson.LoadJsonCollect(bp.searchWeapon(i), "Durability") + "\n");
                    }
                    descriptionLabel.setText(Integer.toString(bp.searchWeapon(i)));
                }
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    weaponLabel[FinalI].setBorder(BorderFactory.createLineBorder(Color.red));

                    for(int j = 0; j < 18; j++){
                        if(j != FinalI){
                            weaponLabel[j].setBorder(BorderFactory.createLineBorder(Color.white));
                        }
                    }

                }
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    descriptionLabel.setText("");

                }

            });


        }
        for(i = 0; i < 18; i++){
            int FinalI = i;
            armorLabel[i].setBorder(BorderFactory.createLineBorder(Color.white));
//            weaponLabel[i].setIcon(new ImageIcon("Resource/images/" + weaponinventory[i] + ".png"));
            armorLabel[i].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    /*
                    {
  "ArmorID" : 30,
  "ArmorName" : "cloth",
  "defense" : 1,
  "durability" : 10
}
                     */
                    if(bp.searchArmor(i)==0){
                        descriptionLabel.setText("Empty");
                    }else {
                        descriptionLabel.setText("ArmorName :" + retJson.LoadJsonCollect(bp.searchArmor(i), "Name") + "\n" +
                                "Defense :" + retJson.LoadJsonCollect(bp.searchArmor(i), "Defense") + "\n" +
                                "Durability :" + retJson.LoadJsonCollect(bp.searchArmor(i), "Durability") + "\n");
                    }
                }
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    armorLabel[FinalI].setBorder(BorderFactory.createLineBorder(Color.red));

                    for(int j = 0; j < 18; j++){
                        if(j != FinalI){
                            armorLabel[j].setBorder(BorderFactory.createLineBorder(Color.white));
                        }
                    }

                }
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    descriptionLabel.setText("");

                }

            });

        }
        for(i = 0; i < 18; i++){
            int FinalI = i;
            foodLabel[i].setBorder(BorderFactory.createLineBorder(Color.white));
//            weaponLabel[i].setIcon(new ImageIcon("Resource/images/" + weaponinventory[i] + ".png"));
            foodLabel[i].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    /*
                    {
    "FoodID" : 50,
    "FoodName" : "Apple",
    "FoodType" : "hungry",
    "hungry" : 2
}
                     */
                    if(bp.searchFood(i)==0){
                        descriptionLabel.setText("Empty");
                    }else {
                        descriptionLabel.setText("FoodName :" + retJson.LoadJsonCollect(bp.searchFood(i), "Name") + "\n" +
                                "FoodType :" + retJson.LoadJsonCollect(bp.searchFood(i), "FoodType") + "\n" +
                                "hungry :" + retJson.LoadJsonCollect(bp.searchFood(i), "hungry") + "\n" +
                                "heal :" + retJson.LoadJsonCollect(bp.searchFood(i), "heal") + "\n" +
                                "thirst :" + retJson.LoadJsonCollect(bp.searchFood(i), "thirst") + "\n");
                    }
                }
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    foodLabel[FinalI].setBorder(BorderFactory.createLineBorder(Color.red));

                    for(int j = 0; j < 18; j++){
                        if(j != FinalI){
                            foodLabel[j].setBorder(BorderFactory.createLineBorder(Color.white));
                        }
                    }

                }
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    descriptionLabel.setText("");
                }


            });


        }




        setBackground(new Color(164,100,10));




        setSize(300, 300);
        setVisible(true);
    }
    public void setWeaponInventory(){


    }
}