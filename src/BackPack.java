public class BackPack {
    private  int[]  weaponinventory;
    private  int[]  armorinventory;
    private  int[]  foodinventory;
    private int size;
    private int stack;

    public void setWeaponInventory(int size){
        weaponinventory = new int[size];
        stack = 0;
    }

    public void addWeapon(int item){
        if(stack < size){
            weaponinventory[stack] = item;
            stack++;
        }
    }
    public void removeWeapon(int item){
        for(int i = 0; i < stack; i++){
            if(weaponinventory[i] == item){
                weaponinventory[i] = 0;
                stack--;
                break;
            }
        }
    }
    public void setArmorInventory(int size){
        armorinventory = new int[size];
        stack = 0;
    }

    public void addArmor(int item){
        if(stack < size){
            armorinventory[stack] = item;
            stack++;
        }
    }

    public void removeArmor(int item){
        for(int i = 0; i < stack; i++){
            if(armorinventory[i] == item){
                armorinventory[i] = 0;
                stack--;
                break;
            }
        }
    }

    public void setFoodInventory(int size){
        foodinventory = new int[size];
        stack = 0;
    }

    public void addFood(int item){
        if(stack < size){
            foodinventory[stack] = item;
            stack++;
        }
    }

    public void removeFood(int item){
        for(int i = 0; i < stack; i++){
            if(foodinventory[i] == item){
                foodinventory[i] = 0;
                stack--;
                break;
            }
        }
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
    public int getStack(){
        return stack;
    }
    public int getSize(){
        return size;
    }

}
