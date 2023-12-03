public class MainStat {
    PlayerInfo player;
    BackPack backpack;
    ZombieInfo enamy;
    BattleUI battleUI;
    public void GameData(){
        player = new PlayerInfo();
        backpack = new BackPack();
        enamy = new ZombieInfo();
    }

    public PlayerInfo getPlayer(){
        return player;
    }
    public BackPack getBackpack(){
        return backpack;
    }
    public ZombieInfo getEnamy(){
        return enamy;
    }
    public int getRoom(){
        return player.getRoom();
    }
    public int getFloor(){
        return player.getFloor();
    }
}
