package xunit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

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

    @Test
    void exceptionTest() {
        wasRun = new WasRun("testMethodWithException");
        wasRun.run();
        assertEquals(wasRun.log, "setUp testMethod tearDown");
    }



}
