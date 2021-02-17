package com.example.money;

public class Dollar {

    int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public void times(int factor) {
        this.amount *= factor;
    }
}
