package com.example.money;

public class Money implements Expression{

    protected int amount;
    protected String currency;

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money won(int amount) {
        return new Money(amount, "WON");
    }

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money times(int factor) {
        return new Money(this.amount * factor, currency);
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Money)) return false;

        Money money = (Money) o;

        return amount == money.amount && currency.equals(money.currency);

    }

    @Override
    public int hashCode() {
        return amount;
    }

    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency,to);
        return new Money(amount/rate, to);
    }
}
