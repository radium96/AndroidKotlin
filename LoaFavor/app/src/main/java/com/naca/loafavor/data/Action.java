package com.naca.loafavor.data;

public class Action {
    private int id;
    private String name;
    private int figure;
    private int[] figureArr;

    public Action(int id, String name){
        this.id = id;
        this.name = name;
        figureArrSetting();
        figure = figureArr[id];
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

    public int getFigure() {
        return figure;
    }

    public void setFigure(int figure) {
        this.figure = figure;
    }

    public int[] getFigureArr() {
        return figureArr;
    }

    public void setFigureArr(int[] figureArr) {
        this.figureArr = figureArr;
    }

    public void figureArrSetting(){
        figureArr = new int[67];
        figureArr[6] = figureArr[7] = figureArr[24] = figureArr[25] = figureArr[31] = figureArr[32] =
                figureArr[33] = figureArr[35] = figureArr[36] = figureArr[37] = figureArr[39] = figureArr[40] =
                        figureArr[41] = figureArr[43] = figureArr[45] = figureArr[50] = figureArr[51] = 250;

        figureArr[1] = figureArr[3] = figureArr[4] = figureArr[5] = figureArr[11] = figureArr[12] =
                figureArr[15] = figureArr[16] = figureArr[17] = figureArr[18] = figureArr[19] = figureArr[53] =
                        figureArr[57] = figureArr[59] = 275;

        figureArr[14] = figureArr[26] = figureArr[27] = figureArr[30] = figureArr[49] = figureArr[54] =
                figureArr[56] = figureArr[61] = figureArr[62] = 300;

        figureArr[55] = 325;

        figureArr[9] = figureArr[58] = figureArr[63] = figureArr[64] = figureArr[65] = 350;

        figureArr[8] = figureArr[10] = figureArr[20] = figureArr[21] = figureArr[23] = figureArr[52] =
                figureArr[60] = 375;

        figureArr[2] = figureArr[13] = figureArr[28] = 400;
    }
}
