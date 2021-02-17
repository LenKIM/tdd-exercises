package com.example.money;

public interface Expression {
    Money reduce(Bank bank, String to);
}
