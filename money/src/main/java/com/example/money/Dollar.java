package com.example.money;

public class Dollar extends Money {

    public Dollar(int amount, String usd) {
        super(amount,usd);
    }

    public int getAmount() {
        return amount;
    }
}
