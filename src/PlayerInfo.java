import java.util.*;
import java.io.*;

public class PlayerInfo {
    //플레이어 체력
    private int HP;
    //플레이어 공격력
    private int ATK;
    //플레이어 방어력
    private int DEF;
    //플레이어 허기 수치
    private int Hunger;
    //플레이어 갈증 수치
    private int Thirst;
    //플레이어 현재 층
    private int Floor;
    //플레이어 현재 방
    private int Room;
    //플레이어 현재 무기
    private int Weapon;
    //플레이어 현재 갑옷
    private int Armor;

    public int getHP(){
        return HP;
    }
    public int getATK(){
        return ATK;
    }
    public int getDEF(){
        return DEF;
    }
    public int getHunger(){
        return Hunger;
    }
    public int getThirst(){
        return Thirst;
    }
    public int getFloor(){
        return Floor;
    }
    public int getRoom(){
        return Room;
    }
    public int getWeapon(){
        return Weapon;
    }
    public int getArmor(){
        return Armor;
    }
    public void setHP(int HP){
        this.HP = HP;
    }
    public void setATK(int ATK){
        this.ATK = ATK;
    }

    public void setDEF(int DEF){
        this.DEF = DEF;
    }
    public void setHunger(int Hunger){
        this.Hunger = Hunger;
    }
    public void setThirst(int Thirst){
        this.Thirst = Thirst;
    }
    public void setFloor(int Floor){
        this.Floor = Floor;
    }
    public void setRoom(int Room){
        this.Room = Room;
    }
    public void setWeapon(int Weapon){
        this.Weapon = Weapon;
    }
    public void setArmor(int Armor){
        this.Armor = Armor;
    }

    public void addHP(int HP){
        this.HP += HP;
    }
    public void addATK(int ATK){
        this.ATK += ATK;
    }
    public void addDEF(int DEF){
        this.DEF += DEF;
    }
    public void addHunger(int Hunger){
        this.Hunger += Hunger;
    }
    public void addThirst(int Thirst){
        this.Thirst += Thirst;
    }
    public void addFloor(int Floor){
        this.Floor += Floor;
    }
    public void addRoom(int Room){
        this.Room += Room;
    }
    public void addWeapon(int Weapon){
        this.Weapon += Weapon;
    }
    public void addArmor(int Armor){
        this.Armor += Armor;
    }

    public void dataSet(){
        HP = 100;
        Hunger = 100;
        Thirst = 100;
        Floor = 0;
        Room = 0;
        Weapon = 0;
        Armor = 0;
    }

}