package ru.itpark.ulmart.domain;

public class Stove extends Product {
    private String type;

    public Stove(int id, String name, int price, String type) {
        super(id, name, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}