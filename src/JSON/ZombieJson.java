package JSON;
/*
{
  "ZombieID" : 100,
  "ZombieName" : "Zombie1",
  "ZombieImg" : "zombie1.png",
  "ZombieType" : 0,
  "ZombieHP" : 30,
  "ZombieAttack" : 5,
  "ZombieDefense" : 0,
  "Zombieaccuracy" : 7
}
 */
public class ZombieJson {
    int ZombieID;
    String ZombieName;
    String ZombieImg;
    int ZombieType;
    int ZombieHP;
    int ZombieAttack;
    int ZombieDefense;
    int Zombieaccuracy;

    public int getZombieID() {
        return ZombieID;
    }

    public String getZombieName() {
        return ZombieName;
    }

    public String getZombieImg() {
        return ZombieImg;
    }

    public int getZombieType() {
        return ZombieType;
    }

    public int getZombieHP() {
        return ZombieHP;
    }

    public int getZombieAttack() {
        return ZombieAttack;
    }

    public int getZombieDefense() {
        return ZombieDefense;
    }

    public int getZombieaccuracy() {
        return Zombieaccuracy;
    }

    public void setInfo(int zombieID){
        LoadJSON loadJSON = new LoadJSON();
        org.json.simple.JSONObject zombie = loadJSON.JsonLoad("src/Resource/json/" + zombieID +".json");
        if(zombie == null)
            zombie = loadJSON.JsonLoad("Resource/json/" + zombieID +".json");
        ZombieID = Integer.parseInt(zombie.get("ZombieID").toString());
        ZombieName = zombie.get("ZombieName").toString();
        ZombieImg = zombie.get("ZombieImg").toString();
        ZombieType = Integer.parseInt(zombie.get("ZombieType").toString());
        ZombieHP = Integer.parseInt(zombie.get("ZombieHP").toString());
        ZombieAttack = Integer.parseInt(zombie.get("ZombieAttack").toString());
        ZombieDefense = Integer.parseInt(zombie.get("ZombieDefense").toString());
        Zombieaccuracy = Integer.parseInt(zombie.get("Zombieaccuracy").toString());
    }
}
