package JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/*
{
    "RoomID" : 303,
    "Background" : "bg_R1.jpg",
    "RoomType" : "Elete",
    "ZombieCount" : 3,
    "Zombie" : [
        8,
        6,
        7
    ],
    "ItemCount" : 3,
    "Item" : [
        1,
        2,
        3
    ]
}
 */
public class ZombieRoomJson {
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
        JSONObject zombieRoom = loadJSON.JsonLoad("Resource/JSON/Room_Zombie.json");
        RoomID = Integer.parseInt(zombieRoom.get("RoomID").toString());
        Background = zombieRoom.get("Background").toString();
        RoomType = zombieRoom.get("RoomType").toString();
        ZombieCount = Integer.parseInt(zombieRoom.get("ZombieCount").toString());
        JSONArray zombies = (JSONArray) zombieRoom.get("Zombie");
        Zombie = new int[ZombieCount];
        for(int i = 0; i<ZombieCount;i++){
            Zombie[i] = Integer.parseInt(zombies.get(i).toString());
        }
        ItemCount = Integer.parseInt(zombieRoom.get("ItemCount").toString());
        JSONArray items = (JSONArray) zombieRoom.get("Item");
        Item = new int[ItemCount];
        for(int i = 0; i<ItemCount;i++){
            Item[i] = Integer.parseInt(items.get(i).toString());
        }
    }
}
