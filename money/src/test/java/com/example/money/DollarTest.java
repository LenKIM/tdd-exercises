package com.example.money;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DollarTest {

    @Test
    void testMultiplication() {
        Money five = Money.dollar(5);

        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));

    }

    @Test
    void testWonMultiplication() {
        Money five = Money.won(5);

        assertEquals(Money.won(10), five.times(2));
        assertEquals(Money.won(15), five.times(3));

    }

    @Test
    void equality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(Money.won(5).equals(Money.won(5)));
        assertFalse(Money.won(5).equals(Money.won(6)));

        assertFalse(Money.dollar(5).equals(Money.won(5)));
    }

//    @Test
//    void simpleAddition() {
//        Money sum = Money.dollar(5).plus(Money.dollar(5));
//        assertEquals(Money.dollar(10), sum);
//    }

    @Test
    void simpleAddition() {
        Money _5$ = Money.dollar(5);
        Expression sum = new Sum(Money.dollar(5), _5$);
        Bank bank = new Bank();
        Money reduced = bank.reduced(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }
}
