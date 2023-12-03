package JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/*
{
    "RoomID" : 103,
    "Background" : "bg_S1.jpg"
}
 */
public class StairRoomJson {

    int RoomID;
    String Background;

    public int getRoomID() {
        return RoomID;
    }
    public String getBackground() {
        return Background;
    }

    public void setInfo(int roomID){
        LoadJSON loadJSON = new LoadJSON();
        JSONObject stairRoom = loadJSON.JsonLoad("src/Resource/json/" + roomID +".json");
        if(stairRoom == null)
            stairRoom = loadJSON.JsonLoad("Resource/json/" + roomID +".json");
        RoomID = Integer.parseInt(stairRoom.get("RoomID").toString());
        Background = stairRoom.get("BackGround").toString();
    }
}
