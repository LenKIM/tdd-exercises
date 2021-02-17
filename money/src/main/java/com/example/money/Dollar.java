package com.example.money;

public class Dollar {

    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int factor) {
        return new Dollar(this.amount * factor);
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dollar)) return false;

        Dollar dollar = (Dollar) o;

        return amount == dollar.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }
}
