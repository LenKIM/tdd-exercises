package xunit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class XUnitTest {

    WasRun wasRun;

    @BeforeEach
    void setUp() {
        wasRun = new WasRun("testMethod");
    }

    @Test
    public void templateTestMethod() {
        assertEquals(wasRun.log, "");
        wasRun.run();
        assertEquals(wasRun.log, "setUp testMethod tearDown");
    }


}
