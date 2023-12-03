package JSON;

/*
{
  "FoodID" : 50,
  "FoodName" : "Apple",
  "FoodType" : "hungry",
  "hungry" : 2
}
 */
public class FoodJson {

        private int foodID;
        private String foodName;
        private String foodType;
        private int hungry;
        private int heal;
        private int thirst;

        public int getFoodID() {
            return foodID;
        }

        public String getFoodName() {
            return foodName;
        }

        public String getFoodType() {
            return foodType;
        }

        public int getHungry() {
            return hungry;
        }
        public int getHeal() {
            return heal;
        }
        public int getThirst() {
            return thirst;
        }

        public void setInfo(int foodID) {
            LoadJSON loadJSON = new LoadJSON();
            org.json.simple.JSONObject food = loadJSON.JsonLoad("src/Resource/json/" + foodID + ".json");
            this.foodID = Integer.parseInt(food.get("FoodID").toString());
            foodName = food.get("FoodName").toString();
            foodType = food.get("FoodType").toString();
            if(foodType.equals("hungry")) {
                hungry = Integer.parseInt(food.get("hungry").toString());
            }
            else if(foodType.equals("heal")) {
                heal = Integer.parseInt(food.get("heal").toString());
            }
            else if(foodType.equals("thirst")) {
                thirst = Integer.parseInt(food.get("thirst").toString());
            }

        }
}
