package org.example.main;

public class Drink {
    private int price;
    private String aKind;

    public Drink(String aKind, int price) {
        this.aKind = aKind;
        this.price = price;
    }

    public int price() {
        return price;
    }
}
