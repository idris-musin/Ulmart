package ru.itpark.ulmart.domain;

public class Electrolux extends Stove {
    private int ovenVolume;
    private int width;
    private int depth;
    private int height;

    public Electrolux(int id, String name, int price, String type, int ovenVolume, int width, int depth, int height) {
        super(id, name, price, type);
        this.ovenVolume = ovenVolume;
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

    public int getOvenVolume() {
        return ovenVolume;
    }

    public void setOvenVolume(int ovenVolume) {
        this.ovenVolume = ovenVolume;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
