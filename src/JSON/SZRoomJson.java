package JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class SZRoomJson {
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
        JSONObject  SZRoom = loadJSON.JsonLoad("src/Resource/json/" + roomID +".json");
        if(SZRoom == null)
            SZRoom = loadJSON.JsonLoad("Resource/json/" + roomID +".json");
        RoomID = Integer.parseInt( SZRoom.get("RoomID").toString());
        Background =  SZRoom.get("BackGround").toString();
        ZombieQuality = Integer.parseInt( SZRoom.get("ZombieQuality").toString());
        ZombieCount = Integer.parseInt( SZRoom.get("ZombieCount").toString());
        Event = Integer.parseInt( SZRoom.get("Event").toString());
        ItemCount = Integer.parseInt(SZRoom.get("ItemsCount").toString());
    }
}
