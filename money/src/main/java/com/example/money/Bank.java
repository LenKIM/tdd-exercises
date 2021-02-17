package com.example.money;

public class Bank {

//    public Money reduced(Expression source, String to) {
//        if (source instanceof Money)return (Money) source;
//        Sum sum = (Sum) source;
//        return sum.reduce(to);
//    }

    public Money reduced(Expression source, String to) {
        return source.reduce(to);
    }
}
