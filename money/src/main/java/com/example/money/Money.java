package com.example.money;

public class Money {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money won(int amount) {
        return new Money(amount, "WON");
    }

    public Money times(int multiFactor) {
//        this.amount *= multiFactor;
        return new Money(amount * multiFactor, currency);
    }

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;
        return money.amount == amount && currency().equals(money.currency);
    }

    String currency() {
        return currency;
    }
}
