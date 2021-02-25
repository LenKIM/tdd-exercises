package xunit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XUnitTest {

    WasRun wasRun;

    @BeforeEach
    void setUp() {
        wasRun = new WasRun("testMethod");
    }

    @Test
    public void createAndRun_testMethod() {
        assertFalse(wasRun.isRun);
        wasRun.run();
        assertTrue(wasRun.isRun);
    }

    @Test
    void setUpMethod() {
        assertFalse(wasRun.wasSetUp);
        assertFalse(wasRun.isRun);
        wasRun.run();
        assertTrue(wasRun.isRun);
        assertTrue(wasRun.wasSetUp);
    }

    @Test
    void tearDownMethod() {
        assertFalse(wasRun.tearDown);
        assertFalse(wasRun.wasSetUp);
        assertFalse(wasRun.isRun);
        wasRun.run();
        assertTrue(wasRun.isRun);
        assertTrue(wasRun.wasSetUp);
        assertTrue(wasRun.tearDown);
    }



}
