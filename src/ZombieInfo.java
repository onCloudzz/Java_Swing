import JSON.SZRoomJson;
import JSON.ZombieJson;

public class ZombieInfo {
    int [] enamyID;
    int [] enamyHP;
    int [] enamyATK;
    int [] enamyDEF;
    int [] enamyDurability;

    public void setEnamyInfo(int roomID){
        if(roomID%1000 == 1){
            return;
        }
        if(roomID%1000 == 2){
            return;
        }
        if(roomID%1000 == 3){
            SZRoomJson szRoomJson = new SZRoomJson();
            szRoomJson.setInfo(roomID);
        }
        if(roomID%1000 == 4){
            ZombieJson zombieJson = new ZombieJson();
            zombieJson.setInfo(roomID);

        }
    }
}
