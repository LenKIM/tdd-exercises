package com.example.money;

public class Won extends Money {

    protected Won(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    public String currency() {
        return currency;
    }

}