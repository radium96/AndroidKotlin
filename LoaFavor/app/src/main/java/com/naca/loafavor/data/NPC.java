package com.naca.loafavor.data;

import android.util.Log;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class NPC {

    private int id;
    private String name;
    private String location;
    private int rank;
    private int[] favorFigure;
    private int status_int;
    private String status;
    private int nowFigure;
    private int limit;
    private int remain;

    public NPC(int id, String name, String location, int rank, int status_int, int nowFigure){
        this.id = id;
        this.name = name;
        this.location = location;
        this.rank = rank;
        this.status_int = status_int;
        this.nowFigure = nowFigure;

        getStatus();
        limit = 0;
        getFavorFigure();
        getLimit();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int[] getFavorFigure() {
        int[] rankArr = new int[10];
        switch (rank){
            case 1:
                rankArr[0] = 400; rankArr[1] = 600; rankArr[2] = 2000;
                rankArr[3] = 7100; rankArr[4] = 11000; rankArr[5] = 12000;
                rankArr[6] = 15000; rankArr[7] = 15000; rankArr[8] = 15000;
                rankArr[9] = 26000;
                break;
            case 2:
                rankArr[0] = 300; rankArr[1] = 400; rankArr[2] = 1100;
                rankArr[3] = 3400; rankArr[4] = 5200; rankArr[5] = 6800;
                rankArr[6] = 7000; rankArr[7] = 7000; rankArr[8] = 7000;
                rankArr[9] = -1;
                break;
            case 3:
                rankArr[0] = 200; rankArr[1] = 200; rankArr[2] = 500;
                rankArr[3] = 1400; rankArr[4] = 1900; rankArr[5] = 2300;
                rankArr[6] = 2700; rankArr[7] = 4000; rankArr[8] = 4800;
                rankArr[9] = -1;
                break;
            case 4:
                rankArr[0] = 100; rankArr[1] = 100; rankArr[2] = 200;
                rankArr[3] = 500; rankArr[4] = 700; rankArr[5] = 800;
                rankArr[6] = 900; rankArr[7] = 1200; rankArr[8] = 1500;
                rankArr[9] = -1;
                break;
            case 5:
                rankArr[0] = 0; rankArr[1] = 0; rankArr[2] = 0;
                rankArr[3] = 0; rankArr[4] = 0; rankArr[5] = 0;
                rankArr[6] = 0; rankArr[7] = 0; rankArr[8] = 0;
                rankArr[9] = 0;
                break;
            case 6:
                rankArr[0] = 350; rankArr[1] = 500; rankArr[2] = 1500;
                rankArr[3] = 5300; rankArr[4] = 8000; rankArr[5] = 9500;
                rankArr[6] = 11000; rankArr[7] = 11000; rankArr[8] = 11000;
                rankArr[9] = -1;
                break;
            case 7:
                rankArr[0] = 500; rankArr[1] = 700; rankArr[2] = 2500;
                rankArr[3] = 9000; rankArr[4] = 15000; rankArr[5] = 15000;
                rankArr[6] = 20000; rankArr[7] = 20000; rankArr[8] = 20000;
                rankArr[9] = -1;
                break;
        }

        favorFigure = rankArr;
        return favorFigure;
    }

    public void setFavorFigure(int[] favorFigure) {
        this.favorFigure = favorFigure;
    }

    public int getStatus_int() {
        return status_int;
    }

    public void setStatus_int(int status_int) {
        this.status_int = status_int;
    }

    public String getStatus() {
        switch (status_int){
            case 0:
                status = "무관심";
                break;
            case 1:
                status = "보통 1단계";
                break;
            case 2:
                status = "보통 2단계";
                break;
            case 3:
                status = "관심 1단계";
                break;
            case 4:
                status = "관심 2단계";
                break;
            case 5:
                status = "관심 3단계";
                break;
            case 6:
                status = "우호 1단계";
                break;
            case 7:
                status = "우호 2단계";
                break;
            case 8:
                status = "우호 3단계";
                break;
            case 9:
                status = "신뢰";
                break;
            default:
                status = "애정";
                break;
        }

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNowFigure() {
        return nowFigure;
    }

    public void setNowFigure(int nowFigure) {
        this.nowFigure = nowFigure;
    }

    public int getLimit() {
        limit = 0;
        for(int i = 0;i<favorFigure.length-1;i++){
            limit += favorFigure[i];
        }
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRemain() {
        remain = limit;
        for (int i = 0;i<status_int;i++){
            remain -= favorFigure[i];
        }
        remain -= nowFigure;
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }
}
