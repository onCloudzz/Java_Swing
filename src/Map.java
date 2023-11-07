import com.sun.source.util.ParameterNameProvider;

import java.sql.Time;
import java.util.*;
import java.io.*;

public class Map {

    private int [][] Map;




    public Map(){
    }



    public void createMap(int difficulty){
        Map = new int[100][5];
        for(int i= 0;i<100;i++){
            for(int j= 0; j<5;j++){
                Map[i][j]=0;
            }
        }
        if(difficulty == 1){
            Map = setZombieeasy(Map);
        }else if(difficulty == 2){
            Map = setZombiehard(Map);
        }
    }

    /*
        방 타입과 방 번호(이 중 랜덤하게 배정, 중복도 가능)
    -1 :시작하는 방
    2 : 내려가는 계단방
    1001~1999 : 좀비방
    2001~2020 : 스토리 방

    6000~6100 : 이벤트 방
    5001~5999 : 재료 방
    701~710 : 보스 방

    좀비방은 항상 층당 1~3개
    좀비방과 계단 방이 아닌 방은 스토리방 혹은 재료방 혹은 이벤트 방
    좀비방은 20층당 100번 단위로 그 안에서 중복 포함 랜덤방으로 세팅
    501~999 번은 하드 모드 전용 방 세팅

    1. 시작 방 생성
    2. 각 층별로 계단방 위치 선정
    3. 각 층별로 좀비방 1~3개 개수 결정
    4. 각 층 별로 좀비방 위치 선정
    5. 3층부터 5층 단위로 좀비방이 아닌 곳에 스토리 방 1곳 선정
    6. 49층과 99층에 좀비방이 아닌 곳에 보스방 설정
    7. 나머지 전체 방 개수의 1/4는 이벤트 방 나머지는 재료 방 설정


        */
    public int[][] setZombieeasy(int[][] Map){
        Random rand = new Random();
//        1. 시작 방 생성
        Map[0][rand.nextInt(5)] = -1;
//        2. 각 층별로 계단방 위치 선정
        for(int i = 0; i< 99; i++){
            int num = rand.nextInt(5);
            Map[i][num] = 2;
            if(Map[i][num]==-1){
                i--;
            }
        }
//        3. 각 층별로 좀비방 1~3개 개수 결정
        int[] zombie = new int[100];
        for(int i = 0; i< 100; i++){
            zombie[i] = rand.nextInt(3)+1;
        }

//        4. 각 층 별 5개의 방중 zombie[i]개의 중복되지 않은 좀비방 위치 선정 이때 계단방과 시작방은 제외
        int[][] realzombie = new int[100][];
        for(int i = 0; i< 100; i++) {
            realzombie[i] = new int[zombie[i]];
        }

        for(int i = 0; i< 100; i++){

        }



        return Map;
    }

    public int[][] setZombiehard(int[][] Map){
        int i = 0;

        return Map;
    }


    public int[][] getMap(){
        return this.Map;
    }
}