package JSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
         
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LoadJSON {


    public JSONObject JsonLoad(String path) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            Reader reader = new FileReader(path);
            jsonObject = (JSONObject) parser.parse(reader);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("파일을 읽을 수 없습니다.");
        } catch (ParseException e) {
            System.out.println("파일을 파싱할 수 없습니다.");
        }
        return jsonObject;
    }
}