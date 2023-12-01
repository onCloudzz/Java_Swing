package JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/*
{
    "RoomID" : 303,
    "Background" : "bg_I1.jpg",
    "ZombieCount" : 3,
    "ZombieQuality" : 6,
    "Event" : true,
    "ItemsCount" : 3
}
 */
public class ZombieRoomJson {
    int RoomID;
    String Background;
    int ZombieCount;
    int ZombieQuality;
    int Event;
    int ItemCount;

    public int getRoomID() {
        return RoomID;
    }
    public String getBackground() {
        return Background;
    }
    public int getZombieCount() {
        return ZombieCount;
    }
    public int getZombieQuality() {return ZombieQuality;}
    public int getItemCount() {
        return ItemCount;
    }
    public int getEvent() {
        return Event;
    }

    public void setInfo(int roomID){
        LoadJSON loadJSON = new LoadJSON();
        JSONObject zombieRoom = loadJSON.JsonLoad("Resource/JSON/" + roomID +".json");
        RoomID = Integer.parseInt(zombieRoom.get("RoomID").toString());
        Background = zombieRoom.get("Background").toString();
        ZombieQuality = Integer.parseInt(zombieRoom.get("ZombieQuality").toString());
        ZombieCount = Integer.parseInt(zombieRoom.get("ZombieCount").toString());
        Event = Integer.parseInt(zombieRoom.get("Event").toString());
        ItemCount = Integer.parseInt(zombieRoom.get("ItemCount").toString());
    }
}
