package JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ItemRoomJson {

    /*
    {
    "RoomID": 1,
    "Background": "bg_I1.jpg",
    "Event" : false,
    "ItemsCount" : 2,
    "Item" :[
        1,
        3
    ]
    }
    Resource/JSON/Room_Item.json
     */
    int RoomID;
    String Background;
    boolean Event;
    int ItemsCount;
    int[] Item;
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
    public int[] getItem() {
        return Item;
    }

    public void setInfo(){
        LoadJSON loadJSON = new LoadJSON();
        JSONObject itemRoom = loadJSON.JsonLoad("Resource/JSON/Room_Item.json");
        RoomID = Integer.parseInt(itemRoom.get("RoomID").toString());
        Background = itemRoom.get("Background").toString();
        Event = Boolean.parseBoolean(itemRoom.get("Event").toString());
        ItemsCount = Integer.parseInt(itemRoom.get("ItemsCount").toString());
        JSONArray items = (JSONArray) itemRoom.get("Item");
        Item = new int[ItemsCount];
        for(int i = 0; i<ItemsCount;i++){
            Item[i] = Integer.parseInt(items.get(i).toString());
        }

    }

}