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
    int Event;
    int ItemsCount;
    public int getRoomID() {
        return RoomID;
    }
    public String getBackground() {
        return Background;
    }
    public int getEvent() {
        return Event;
    }
    public int getItemsCount() {
        return ItemsCount;
    }

    public void setInfo(int roomID){
        LoadJSON loadJSON = new LoadJSON();
        JSONObject itemRoom = loadJSON.JsonLoad("src/Resource/json/" + roomID +".json");
        if(itemRoom == null)
            itemRoom = loadJSON.JsonLoad("Resource/json/" + roomID +".json");
        RoomID = Integer.parseInt(itemRoom.get("RoomID").toString());
        Background = itemRoom.get("BackGround").toString();
        Event = Integer.parseInt(itemRoom.get("Event").toString());
        ItemsCount = Integer.parseInt(itemRoom.get("ItemsCount").toString());
    }

}