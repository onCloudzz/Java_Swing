package JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
{
  "WeaponID" : 11,
  "WeaponName" : "Punch",
  "damage" : 2,
  "accuracy" : 10,
  "durability" : 10
}
 */
public class WeaponJson
{
    private int weaponID;
    private String weaponName;
    private int damage;
    private int accuracy;
    private int durability;
    public int getWeaponID()
    {
        return weaponID;
    }
    public String getWeaponName()
    {
        return weaponName;
    }
    public int getDamage()
    {
        return damage;
    }
    public int getAccuracy()
    {
        return accuracy;
    }
    public int getDurability()
    {
        return durability;
    }


    public void setInfo(int weaponID)
    {
        LoadJSON loadJSON = new LoadJSON();
        JSONObject weapon = loadJSON.JsonLoad("src/Resource/json/" + weaponID + ".json");
        if(weapon == null)
            weapon = loadJSON.JsonLoad("Resource/json/" + weaponID + ".json");
        this.weaponID = Integer.parseInt(weapon.get("WeaponID").toString());
        weaponName = weapon.get("WeaponName").toString();
        damage = Integer.parseInt(weapon.get("damage").toString());
        accuracy = Integer.parseInt(weapon.get("accuracy").toString());
        durability = Integer.parseInt(weapon.get("durability").toString());
    }
}
