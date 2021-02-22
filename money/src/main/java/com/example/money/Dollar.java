package com.example.money;

public class Dollar extends Money {

    protected Dollar(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    public String currency() {
        return currency;
    }

}
