import com.sun.source.util.ParameterNameProvider;

import java.sql.Time;
import java.util.*;
import java.io.*;

public class Map {

    private int [][] Map;




    public Map(){
    }



    public void createMap(int difficulty, int seed){
        Map = new int[100][5];
        for(int i= 0;i<100;i++){
            for(int j= 0; j<5;j++){
                Map[i][j]=0;
            }
        }
        if(difficulty == 1){
            Map = setZombieeasy(Map, seed);
        }else if(difficulty == 2){
            Map = setZombiehard(Map, seed);
        }
    }

    /*
        방 타입과 방 번호(이 중 랜덤하게 배정, 중복도 가능)
    -1 :시작하는 방
    2 : 내려가는 계단방
    1000~1999 : 좀비방
    2000~2019 : 스토리 방
    3,8,13,18,23,28,33,38,43,48,53,58,63,68,73,78,83,88,93,98 : 스토리 층

    3000~3099 : 이벤트 방
    3100~3499 : 재료 방
    7000~7004 : easy 초반 보스방 49층
    7005~7009 : easy 후반 보스방 99층
    7010~7014 : hard 초반 보스방
    7015~7019 : hard 후반 보스방

    10000 : 백신방
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
    public int[][] setZombieeasy(int[][] Map, int seed){
        Random rand = new Random(seed);
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
            for(int j = 0; j<zombie[i];j++){
                int num = rand.nextInt(5);
                if(Map[i][num]!=0){
                    j--;
                }else{
                    realzombie[i][j] = num;
                }
            }
        }


        //4-1. realzombie에 저장된 좀비방 위치를 Map에 저장
        for(int i = 0; i< 100; i++){
            for(int j = 0; j<zombie[i];j++) {
                if (i < 20) {
                    Map[i][realzombie[i][j]] = 1000 + rand.nextInt(100);
                }else if(i<40){
                    Map[i][realzombie[i][j]] = 1100 + rand.nextInt(100);
                }else if(i<60){
                    Map[i][realzombie[i][j]] = 1200 + rand.nextInt(100);
                }else if(i<80){
                    Map[i][realzombie[i][j]] = 1300 + rand.nextInt(100);
                }else{
                    Map[i][realzombie[i][j]] = 1400 + rand.nextInt(100);
                }
            }
        }
//        5. 3층부터 5층 단위로 좀비방이 아닌 곳에 스토리 방 1곳 선정
        int[] story = {2, 7, 12, 17, 22, 27, 32, 37, 42, 47, 52, 57, 62, 67, 72, 77, 82, 87, 92, 97};
        int cnt = 0;
        for(int i = 0; i < story.length;i++){
            int num = rand.nextInt(5);
            if(Map[story[i]][num]==0) {
                Map[story[i]][num] = 2000 + cnt;
                cnt++;
            }else{
                i--;
            }
        }

        //6. 49층과 99층에 좀비방이 아닌 곳에 보스방 설정
        cnt = 0;
        do {
            int num = rand.nextInt(5);
            if (Map[48][num] == 0) {
                Map[48][num] = 7000 + rand.nextInt(5);
                cnt++;
            }
        }while (cnt!=1);
        do {
            int num = rand.nextInt(5);
            if (Map[48][num] == 0) {
                Map[48][num] = 7005 + rand.nextInt(5);
                cnt++;
            }
        }while (cnt!=2);
//      6-1. 마지막 층에 백신 방 배치
        do {
            int num = rand.nextInt(5);
            if (Map[99][num] == 0) {
                Map[99][num] = 10000;
                cnt++;
            }
        }while (cnt!=3);

//        7. 재료방 설정
        for(int i = 0; i<100;i++){
            for(int j = 0; j<5;j++){
                if(Map[i][j]==0){
                    Map[i][j] = 3000 + rand.nextInt(500);
                }
            }
        }



        //견본 맵 출력
        for(int i = 0; i<100;i++){
            for(int j = 0; j<5;j++){
                System.out.print(Map[i][j] + " ");
            }
            System.out.println();
        }
        return Map;
    }

    public int[][] setZombiehard(int[][] Map, int seed){
        Random rand = new Random(seed);
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
            for(int j = 0; j<zombie[i];j++){
                int num = rand.nextInt(5);
                if(Map[i][num]!=0){
                    j--;
                }else{
                    realzombie[i][j] = num;
                }
            }
        }


        //4-1. realzombie에 저장된 좀비방 위치를 Map에 저장
        for(int i = 0; i< 100; i++){
            for(int j = 0; j<zombie[i];j++) {
                if (i < 20) {
                    Map[i][realzombie[i][j]] = 1500 + rand.nextInt(100);
                }else if(i<40){
                    Map[i][realzombie[i][j]] = 1600 + rand.nextInt(100);
                }else if(i<60){
                    Map[i][realzombie[i][j]] = 1700 + rand.nextInt(100);
                }else if(i<80){
                    Map[i][realzombie[i][j]] = 1800 + rand.nextInt(100);
                }else{
                    Map[i][realzombie[i][j]] = 1900 + rand.nextInt(100);
                }
            }
        }
//        5. 3층부터 5층 단위로 좀비방이 아닌 곳에 스토리 방 1곳 선정
        int[] story = {2, 7, 12, 17, 22, 27, 32, 37, 42, 47, 52, 57, 62, 67, 72, 77, 82, 87, 92, 97};
        int cnt = 0;
        for(int i = 0; i < story.length;i++){
            int num = rand.nextInt(5);
            if(Map[story[i]][num]==0) {
                Map[story[i]][num] = 2000 + cnt;
                cnt++;
            }else{
                i--;
            }
        }

        //6. 49층과 99층에 좀비방이 아닌 곳에 보스방 설정
        cnt = 0;
        do {
            int num = rand.nextInt(5);
            if (Map[48][num] == 0) {
                Map[48][num] = 7000 + rand.nextInt(5);
                cnt++;
            }
        }while (cnt!=1);
        do {
            int num = rand.nextInt(5);
            if (Map[48][num] == 0) {
                Map[48][num] = 7005 + rand.nextInt(5);
                cnt++;
            }
        }while (cnt!=2);
//      6-1. 마지막 층에 백신 방 배치
        do {
            int num = rand.nextInt(5);
            if (Map[99][num] == 0) {
                Map[99][num] = 10000;
                cnt++;
            }
        }while (cnt!=3);

//        7. 재료방 설정
        for(int i = 0; i<100;i++){
            for(int j = 0; j<5;j++){
                if(Map[i][j]==0){
                    Map[i][j] = 3000 + rand.nextInt(500);
                }
            }
        }

        return Map;
    }


    public int[][] getMap(){
        return this.Map;
    }

}