package com.example.money;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 다중 화페를 지원하는 Money 객체 만들기
 *
 */
public class DollarTest {

    @Test
    void simpleApplication() {
        Money five = Money.dollar(5);
        Money _ten = five.times(2);
        assertEquals(Money.dollar(10), _ten);
    }

    @Test
    void wonTest() {
        Money five = Money.won(5);
        Money _ten = five.times(2);
        assertEquals(Money.won(10), _ten);
    }

    @Test
    void equalityTestApplication() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(Money.won(5).equals(Money.won(5)));
        assertFalse(Money.won(5).equals(Money.won(6)));
        assertFalse(Money.won(5).equals(Money.dollar(5)));
    }

    @Test
    void currency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("WON", Money.won(1).currency());
    }
}
