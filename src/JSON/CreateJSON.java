package JSON;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
/*
 ITEM.csv 파일의 예시
 1001,bg_I1.jpg,1,1
 1002,bg_I2.jpg,1,2

    json 파일의 예시
    1001.json
    {
        "RoomID": 1001,
        "BackGround": "bg_I1.jpg",
        "Event": 1,
        "ItemsCount": 1
    }
    1002.json
    {
        "RoomID": 1002,
        "BackGround": "bg_I2.jpg",
        "Event": 1,
        "ItemsCount": 2
    }
 */
//csv 파일을 읽어서 각 줄을 json 파일로 만들어주는 클래스
//csv 파일은 resources/csv 폴더에 있어야 함
//json 파일은 resources/json 폴더에 저장됨
//ITEM.csv의 각 줄은 RoomID, BackGround, Event, ItemsCount 를 키로 사용함
//STAIR.csv의 각 줄은 RoomID, BackGround 를 키로 사용함
//ZOMBIE.csv의 각 줄은 RoomID, BackGround, ZombieCount, ZombieQuality, Event, ItemsCount 를 키로 사용함
//SZ.csv의 각 줄은 RoomID, BackGround, ZombieCount, ZombieQuality, Event, ItemsCount 를 키로 사용함
//각 줄의 RoomID를 파일명으로 하고, 해당 줄의 값들을 json 파일로 만들어 줌

public class CreateJSON {
    public static void main(String[] args) {
        //csv 파일을 읽어서 json 파일로 만들어주는 클래스
        //csv 파일은 resources/csv 폴더에 있어야 함
        //json 파일은 resources/json 폴더에 저장됨
        //ITEM.csv의 각 줄은 RoomID, BackGround, Event, ItemsCount 를 키로 사용함
        //STAIR.csv의 각 줄은 RoomID, BackGround 를 키로 사용함
        //ZOMBIE.csv의 각 줄은 RoomID, BackGround, ZombieCount, ZombieQuality, Event, ItemsCount 를 키로 사용함
        //SZ.csv의 각 줄은 RoomID, BackGround, ZombieCount, ZombieQuality, Event, ItemsCount 를 키로 사용함
        //각 줄의 RoomID를 파일명으로 하고, 해당 줄의 값들을 json 파일로 만들어 줌
        try {
            //ITEM.csv 파일을 읽어서 json 파일로 만들어 줌
            BufferedReader br = new BufferedReader(new FileReader("resource/csv/ITEM.csv"));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject obj = new JSONObject();
                obj.put("RoomID", values[0]);
                obj.put("BackGround", values[1]);
                obj.put("Event", values[2]);
                obj.put("ItemsCount", values[3]);
                FileWriter file = new FileWriter("resource/json/" + values[0] + ".json");
                file.write(obj.toJSONString());
                file.flush();
                file.close();
            }
            br.close();
            //STAIR.csv 파일을 읽어서 json 파일로 만들어 줌
            br = new BufferedReader(new FileReader("resource/csv/STAIR.csv"));
            line = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject obj = new JSONObject();
                obj.put("RoomID", values[0]);
                obj.put("BackGround", values[1]);
                FileWriter file = new FileWriter("resource/json/" + values[0] + ".json");
                file.write(obj.toJSONString());
                file.flush();
                file.close();
            }
            br.close();
            //ZOMBIE.csv 파일을 읽어서 json 파일로 만들어 줌
            br = new BufferedReader(new FileReader("resource/csv/ZOMBIE.csv"));
            line = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject obj = new JSONObject();
                obj.put("RoomID", values[0]);
                obj.put("BackGround", values[1]);
                obj.put("ZombieCount", values[2]);
                obj.put("ZombieQuality", values[3]);
                obj.put("Event", values[4]);
                obj.put("ItemsCount", values[5]);
                FileWriter file = new FileWriter("resource/json/" + values[0] + ".json");
                file.write(obj.toJSONString());
                file.flush();
                file.close();
            }
            br.close();
            //SZ.csv 파일을 읽어서 json 파일로 만들어 줌
            br = new BufferedReader(new FileReader("resource/csv/SZ.csv"));
            line = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject obj = new JSONObject();
                obj.put("RoomID", values[0]);
                obj.put("BackGround", values[1]);
                obj.put("ZombieCount", values[2]);
                obj.put("ZombieQuality", values[3]);
                obj.put("Event", values[4]);
                obj.put("ItemsCount", values[5]);
                FileWriter file = new FileWriter("resource/json/" + values[0] + ".json");
                file.write(obj.toJSONString());
                file.flush();
                file.close();
            }
            br.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
