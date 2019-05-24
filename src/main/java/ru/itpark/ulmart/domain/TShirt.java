package ru.itpark.ulmart.domain;

public class TShirt extends Product {
    private int Size;
    private String color;

    public TShirt(int id, String name, int price, int size, String color) {
        super(id, name, price);
        Size = size;
        this.color = color;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
