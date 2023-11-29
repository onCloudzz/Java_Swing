public class BackPack {
    private  int[]  inventory;
    private int size;
    private int stack;

    public void setBackPack(int size){
        inventory = new int[size];
        stack = 0;
    }

    public void addItem(int item){
        if(stack < size){
            inventory[stack] = item;
            stack++;
        }
    }
    public void removeItem(int item){
        for(int i = 0; i < stack; i++){
            if(inventory[i] == item){
                inventory[i] = 0;
                stack--;
                break;
            }
        }
    }
    public int[] getInventory(){
        return inventory;
    }
    public int getStack(){
        return stack;
    }
    public int getSize(){
        return size;
    }

}
