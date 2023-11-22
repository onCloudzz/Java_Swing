package JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class SZRoomJson {
    int RoomID;
    String Background;
    String RoomType;
    int ZombieCount;
    int[] Zombie;
    int ItemCount;
    int[] Item;

    public int getRoomID() {
        return RoomID;
    }
    public String getBackground() {
        return Background;
    }
    public String getRoomType() {
        return RoomType;
    }
    public int getZombieCount() {
        return ZombieCount;
    }
    public int[] getZombie() {
        return Zombie;
    }
    public int getItemCount() {
        return ItemCount;
    }
    public int[] getItem() {
        return Item;
    }

    public void setInfo(){
        LoadJSON loadJSON = new LoadJSON();
        JSONObject  SZRoom = loadJSON.JsonLoad("Resource/JSON/SZ_Zombie.json");
        RoomID = Integer.parseInt( SZRoom.get("RoomID").toString());
        Background =  SZRoom.get("Background").toString();
        RoomType =  SZRoom.get("RoomType").toString();
        ZombieCount = Integer.parseInt( SZRoom.get("ZombieCount").toString());
        JSONArray zombies = (JSONArray) SZRoom.get("Zombie");
        Zombie = new int[ZombieCount];
        for(int i = 0; i<ZombieCount;i++){
            Zombie[i] = Integer.parseInt(zombies.get(i).toString());
        }
        ItemCount = Integer.parseInt(SZRoom.get("ItemCount").toString());
        JSONArray items = (JSONArray) SZRoom.get("Item");
        Item = new int[ItemCount];
        for(int i = 0; i<ItemCount;i++){
            Item[i] = Integer.parseInt(items.get(i).toString());
        }
    }
}
