package JSON;

import java.util.Map;

public class RetJson {
    public String LoadJsonCollect( int a, String b) {
        if (a / 1000 == 1) {
            ItemRoomJson itemRoomJson = new ItemRoomJson();
            itemRoomJson.setInfo(a);
            return switch (b) {
                case "RoomID" -> Integer.toString(itemRoomJson.getRoomID());
                case "Background" -> itemRoomJson.getBackground();
                case "Event" -> Integer.toString(itemRoomJson.getEvent());
                case "ItemsCount" -> Integer.toString(itemRoomJson.getItemsCount());
                default -> "Error";
            };
        } else if (a / 1000 == 2) {
            StairRoomJson stairRoomJson = new StairRoomJson();
            stairRoomJson.setInfo(a);
            if (b.equals("RoomID")) {
                return Integer.toString(stairRoomJson.getRoomID());
            } else if (b.equals("Background")) {
                return stairRoomJson.getBackground();
            } else {
                return "Error";
            }


        } else if (a / 1000 == 3) {
            SZRoomJson szRoomJson = new SZRoomJson();
            szRoomJson.setInfo(a);
            return switch (b) {
                case "RoomID" -> Integer.toString(szRoomJson.getRoomID());
                case "Background" -> szRoomJson.getBackground();
                case "Event" -> Integer.toString(szRoomJson.getEvent());
                case "ItemsCount" -> Integer.toString(szRoomJson.getItemCount());
                default -> "Error";
            };

        }
        else if(a/1000 == 4){
            ZombieRoomJson zombieRoomJson = new ZombieRoomJson();
            zombieRoomJson.setInfo(a);
            return switch (b) {
                case "RoomID" ->  Integer.toString(zombieRoomJson.getRoomID());
                case "Background" -> zombieRoomJson.getBackground();
                case "Event" -> Integer.toString(zombieRoomJson.getEvent());
                case "ItemsCount" -> Integer.toString(zombieRoomJson.getItemCount());
                default -> "Error";
            };
        }else if(a/100 == 1){
            ZombieJson zombieJson = new ZombieJson();
            zombieJson.setInfo(a);
            return switch (b) {
                case "ZombieID" -> Integer.toString(zombieJson.getZombieID());
                case "ZombieName" -> zombieJson.getZombieName();
                case "ZombieImg" -> zombieJson.getZombieImg();
                case "ZombieType" -> Integer.toString(zombieJson.getZombieType());
                case "ZombieHP" -> Integer.toString(zombieJson.getZombieHP());
                case "ZombieAttack" -> Integer.toString(zombieJson.getZombieAttack());
                case "ZombieDefense" -> Integer.toString(zombieJson.getZombieDefense());
                case "Zombieaccuracy" -> Integer.toString(zombieJson.getZombieaccuracy());
                default -> "Error";
            };
        }else if(a/10 == 1){
            WeaponJson weaponJson = new WeaponJson();
            weaponJson.setInfo(a);
            return switch (b) {
                case "WeaponID" -> Integer.toString(weaponJson.getWeaponID());
                case "Name" -> weaponJson.getWeaponName();
                case "WeaponAttack" -> Integer.toString(weaponJson.getDamage());
                case "WeaponAccuracy" -> Integer.toString(weaponJson.getAccuracy());
                case "WeaponDurability" -> Integer.toString(weaponJson.getDurability());
                default -> "Error";
            };
        }
        else if(a/10 == 3){
            ArmorJson armorJson = new ArmorJson();
            armorJson.setInfo(a);
            return switch (b) {
                case "ArmorID" -> Integer.toString(armorJson.getArmorID());
                case "Name" -> armorJson.getArmorName();
                case "ArmorDefense" -> Integer.toString(armorJson.getDefense());
                case "ArmorDurability" -> Integer.toString(armorJson.getDurability());
                default -> "Error";
            };
        }
        else if(a/10 == 5){
            FoodJson foodJson = new FoodJson();
            foodJson.setInfo(a);
            return switch (b) {
                case "FoodID" -> Integer.toString(foodJson.getFoodID());
                case "Name" -> foodJson.getFoodName();
                case "FoodType" -> foodJson.getFoodType();
                case "hungry" -> Integer.toString(foodJson.getHungry());
                case "heal" -> Integer.toString(foodJson.getHeal());
                case "thirst" -> Integer.toString(foodJson.getThirst());
                default -> "Error";
            };
        }
        else return "Error";
    }
}
