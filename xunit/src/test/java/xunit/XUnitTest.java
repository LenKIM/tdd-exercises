package xunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XUnitTest {

    @Test
    public void createAndRun_testMethod() throws Exception {
        WasRun wasRun = new WasRun("testMethod");
        assertFalse(wasRun.isRun);
        wasRun.run();
        assertTrue(wasRun.isRun);
    }
}
