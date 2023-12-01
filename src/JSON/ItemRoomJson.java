package JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ItemRoomJson {

    /*
    {
    "RoomID": 1,
    "Background": "bg_I1.jpg",
    "Event" : false,
    "ItemsCount" : 2
}
    Resource/JSON/Room_Item.json
     */
    int RoomID;
    String Background;
    boolean Event;
    int ItemsCount;
    public int getRoomID() {
        return RoomID;
    }
    public String getBackground() {
        return Background;
    }
    public boolean getEvent() {
        return Event;
    }
    public int getItemsCount() {
        return ItemsCount;
    }

    public void setInfo(int roomID){
        LoadJSON loadJSON = new LoadJSON();
        JSONObject itemRoom = loadJSON.JsonLoad("Resource/JSON/" + roomID +".json");
        RoomID = Integer.parseInt(itemRoom.get("RoomID").toString());
        Background = itemRoom.get("Background").toString();
        Event = Boolean.parseBoolean(itemRoom.get("Event").toString());
        ItemsCount = Integer.parseInt(itemRoom.get("ItemsCount").toString());
    }

}