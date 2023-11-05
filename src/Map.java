import java.sql.Time;
import java.util.*;
import java.io.*;

public class Map {

    private int [][] Map;




    public Map(){
    }


    /*
    방 타입
    -1 : 시작 방
    1 : 내려가는 계단방
    2 : 올라가는 계단방
    3001~3999 : 좀비방
    401~499 : 이벤트 방
    5001~5999 : 재료 방
    601~620 : 스토리 방
    701~710 : 보스 방

    좀비방은 항상 층당 1~3개
    좀비방과 계단 방이 아닌 방은 스토리방 혹은 재료방 혹은 이벤트 방
    좀비방은 20층당 100번 단위로 그 안에서 중복 포함 랜덤방으로 세팅
    3501~3999 번은 하드 모드 전용 방 세팅

    */
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


    public int[][] setZombieeasy(int[][] Map){
        int i = 0;
        for(i = 0; i< 100 ; i++){
            int randCnt = (int)(Math.random()*3)+1;
            //중복되지 않는 0~4 중 랜덤 값 randCnt개
            int[] randArr = new int[randCnt];
            for(int j = 0;j<randCnt;j++){
                randArr[j] = (int)(Math.random()*5);
                for(int k = 0;k<j;k++){
                    if(randArr[j]==randArr[k]){
                        j--;
                        break;
                    }
                }
            }

            for(int j = 0;j<randArr.length;j++){
                if(i<20){
                    Map[i][randArr[j]] = 3000+(int)(Math.random()*100);
                }else if(i<40){
                    Map[i][randArr[j]] = 3100+(int)(Math.random()*100);
                }else if (i<60){
                    Map[i][randArr[j]] = 3200+(int)(Math.random()*100);
                }else if(i<80){
                    Map[i][randArr[j]] = 3300+(int)(Math.random()*100);
                }else{
                    Map[i][randArr[j]] = 3400+(int)(Math.random()*100);
                }
            }
        }

        //좀비 방 카운트
        int zombieCnt = 0;
        for(i = 0; i< 100 ; i++){
            for(int j = 0;j<5;j++){
                if(Map[i][j]>=3000 && Map[i][j]<4000){
                    zombieCnt++;
                }
            }
        }

        //스토리방을 4층, 9층, 14층, 19층, 24층, 29층, 34층, 39층, 44층, 48층, 54층, 59층, 64층, 69층, 74층, 79층, 84층, 89층, 94층, 97층에 좀비방이 아닌 곳에 배치
        int rand = (int)(Math.random()*5);
        int storycnt = 0;
        int[] storyArr = {4,9,14,19,24,29,34,39,44,48,54,59,64,69,74,79,84,89,94,97};
        for(int j = 0;j<20;j++){
            if(Map[storyArr[j]][rand]>=3000 && Map[storyArr[j]][rand]<4000){
                rand = (int)(Math.random()*5);
                j--;
            }else{
                Map[storyArr[j]][rand] = 600+storycnt;
                storycnt++;
            }
        }


        //시작 방을 좀비방이 아닌 0층에 배치
        for(int j = 0;j<5;j++){
            if(Map[0][rand]>=600 && Map[0][rand]<4000){
                rand = (int)(Math.random()*5);
                j--;
            }else{
                Map[0][rand] = -1;
            }
        }

        //보스 방을 좀비방과 스토리방이 아닌 49층과 98층에 배치
        int bossArr[] = {49,98};
        for(int j = 0;j<2;j++){
            if(Map[bossArr[j]][rand]>=3000 && Map[bossArr[j]][rand]<4000){
                rand = (int)(Math.random()*5);
                j--;
            }
            else{
                Map[bossArr[j]][rand] = 700+(int) (Math.random()*20);
            }
        }




        //0~99층까지 중 전체의 남은 방의 1/3을 이벤트 방으로 배치 나머지는 재료방으로 배치
        int eventCnt = zombieCnt/3;
        int materialCnt = zombieCnt-eventCnt;
        int [] eventArr = new int[eventCnt];
        int [] materialArr = new int[materialCnt];
        //이벤트 방은 0~50에서 2/3, 51~99에서 1/3
        int eventCnt1 = 0;
        int eventCnt2 = 0;
        for(i = 0; i< 100 ; i++){
            for(int j = 0;j<5;j++){
                if(Map[i][j]>=3000 && Map[i][j]<4000){
                    if(i<50){
                        if(eventCnt1<eventCnt*2/3){
                            eventArr[eventCnt1] = i;
                            eventCnt1++;
                        }else{
                            materialArr[eventCnt2] = i;
                            eventCnt2++;
                        }
                    }else{
                        if(eventCnt1<eventCnt*1/3){
                            eventArr[eventCnt1] = i;
                            eventCnt1++;
                        }else{
                            materialArr[eventCnt2] = i;
                            eventCnt2++;
                        }
                    }
                }
            }
        }

        //이벤트 방 배치(이벤트 방은 400~499)
        for(int j = 0;j<eventCnt;j++){
            rand = (int)(Math.random()*5);
            if(!(Map[eventArr[j]][rand]>=400 && Map[eventArr[j]][rand]<500)){
                rand = (int)(Math.random()*5);
                j--;
            }else{
                Map[eventArr[j]][rand] = 400+(int)(Math.random()*100);
            }
        }

        //재료 방 배치(재료 방은 5001~5999)
        for(int j = 0;j<materialCnt;j++){
            rand = (int)(Math.random()*5);
            if(!(Map[materialArr[j]][rand]>=5001 && Map[materialArr[j]][rand]<6000)){
                rand = (int)(Math.random()*5);
                j--;
            }else{
                Map[materialArr[j]][rand] = 5001+(int)(Math.random()*100);
            }
        }






        return Map;
    }

    public int[][] setZombiehard(int[][] Map){
        int i = 0;
        for(i = 0; i< 100 ; i++){
            int randCnt = (int)(Math.random()*3)+1;
            //중복되지 않는 0~4 중 랜덤 값 randCnt개
            int[] randArr = new int[randCnt];
            for(int j = 0;j<randCnt;j++){
                randArr[j] = (int)(Math.random()*5);
                for(int k = 0;k<j;k++){
                    if(randArr[j]==randArr[k]){
                        j--;
                        break;
                    }
                }
            }

            for(int j = 0;j<randArr.length;j++){
                if(i<20){
                    Map[i][randArr[j]] = 3500+(int)(Math.random()*100);
                }else if(i<40){
                    Map[i][randArr[j]] = 3600+(int)(Math.random()*100);
                }else if (i<60){
                    Map[i][randArr[j]] = 3700+(int)(Math.random()*100);
                }else if(i<80){
                    Map[i][randArr[j]] = 3800+(int)(Math.random()*100);
                }else{
                    Map[i][randArr[j]] = 3900+(int)(Math.random()*100);
                }
            }
        }
        return Map;
    }


    public int[][] getMap(){
        return this.Map;
    }
}