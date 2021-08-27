package com.naca.loafavor.data;

public class NPC {
    private String name;
    private String location;
    private int[] favorFigure;

    public NPC(String name, String location, int[] favorFigure){
        this.name = name;
        this.location = location;
        this.favorFigure = favorFigure;
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
        return favorFigure;
    }

    public void setFavorFigure(int[] favorFigure) {
        this.favorFigure = favorFigure;
    }
}
