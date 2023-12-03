import javax.swing.*;

public class BackPack {
    private  int[]  weaponinventory = {};
    private  int[]  armorinventory;
    private  int[]  foodinventory;
    private int weaponstack;
    private int armorstack;
    private int foodstack;


    public void addBackPack(int itemID){
        if(itemID/10 == 1){
            addWeapon(itemID);
        }else if(itemID/10 == 3){
            addArmor(itemID);
        }else if(itemID/10 == 5){
            addFood(itemID);
        }
    }

    public void settingBackPack(){
        weaponinventory = new int[18];
        armorinventory = new int[18];
        foodinventory = new int[18];
        for(int i = 0; i < 18; i++){
            weaponinventory[i] = 0;
            armorinventory[i] = 0;
            foodinventory[i] = 0;
        }
    }
    public void setWeaponInventory(){
        weaponinventory = new int[18];
        weaponstack = 0;
    }

    public void addWeapon(int item){
        if(weaponstack < 18){
            weaponinventory[weaponstack] = item;
            weaponstack++;
            if(weaponstack == 18){
                JOptionPane.showMessageDialog(null, "인벤토리가 꽉찼습니다.");
            }
        }
    }
    public void removeWeapon(int item){
        for(int i = item+1; i < weaponstack; i++){
            weaponinventory[i-1] = weaponinventory[i];
        }
        weaponstack--;
    }
    public int searchWeapon(int index){
        if(index < weaponstack){
            return weaponinventory[index];
        }else {
            return weaponinventory[weaponstack-1];
        }
    }
    public void setArmorInventory(){
        armorinventory = new int[18];
        armorstack = 0;
    }

    public void addArmor(int item){
        if(armorstack < 18){
            armorinventory[armorstack] = item;
            armorstack++;
            if(armorstack == 18){
                JOptionPane.showMessageDialog(null, "인벤토리가 꽉찼습니다.");
            }
        }
    }

    public void removeArmor(int index){
        for (int i = index+1; i < armorstack; i++){
            armorinventory[i-1] = armorinventory[i];
        }
        armorstack--;
    }
    public int searchArmor(int index){

        return armorinventory[index];
    }
    public void setFoodInventory(){
        foodinventory = new int[18];
        foodstack = 0;
    }

    public void addFood(int item){
        if(foodstack < 18){
            foodinventory[foodstack] = item;
            foodstack++;
            if(foodstack == 18){
                JOptionPane.showMessageDialog(null, "인벤토리가 꽉찼습니다.");
            }
        }
    }

    public void removeFood(int index){
        for(int i = index+1; i < foodstack; i++){
            foodinventory[i-1] = foodinventory[i];
        }
        foodstack--;
    }
    public int searchFood(int index){
        return 0;
    }
    public int[] getWeaponInventory(){
        return weaponinventory;
    }
    public int[] getArmorInventory(){
        return armorinventory;
    }
    public int[] getFoodInventory(){
        return foodinventory;
    }
    public int getWeaponstack(){
        return weaponstack;
    }
    public int getArmorstack(){
        return armorstack;
    }
    public int getFoodstack(){
        return foodstack;
    }


}
