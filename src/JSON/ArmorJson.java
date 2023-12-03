package JSON;

/*
{
  "ArmorID" : 30,
  "ArmorName" : "cloth",
  "defense" : 1,
  "durability" : 10
}
 */
public class ArmorJson {

        private int armorID;
        private String armorName;
        private int defense;
        private int durability;

        public int getArmorID() {
            return armorID;
        }

        public String getArmorName() {
            return armorName;
        }

        public int getDefense() {
            return defense;
        }

        public int getDurability() {
            return durability;
        }

        public void setInfo(int armorID) {
            LoadJSON loadJSON = new LoadJSON();
            org.json.simple.JSONObject armor = loadJSON.JsonLoad("src/Resource/json/" + armorID + ".json");
            if(armor == null)
                armor = loadJSON.JsonLoad("Resource/json/" + armorID + ".json");
            this.armorID = Integer.parseInt(armor.get("ArmorID").toString());
            armorName = armor.get("ArmorName").toString();
            defense = Integer.parseInt(armor.get("defense").toString());
            durability = Integer.parseInt(armor.get("durability").toString());
        }
}
