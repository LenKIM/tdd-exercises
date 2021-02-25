package xunit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XUnitTest {

    WasRun wasRun;

    @BeforeEach
    void setUp() {
        wasRun = new WasRun("testMethod");
    }

    @Test
    public void templateTestMethod() {
        assertEquals(wasRun.log, "");

        TestResult result = new TestResult();
        wasRun.run(result);
        assertEquals(wasRun.log, "setUp testMethod tearDown");
    }

    @Test
    void exceptionTest() {
        wasRun = new WasRun("testMethodWithException");
        TestResult result = new TestResult();
        wasRun.run(result);
        assertEquals(wasRun.log, "setUp testMethod tearDown");
    }

    @Test
    void testResult() {
        wasRun = new WasRun("testMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        assertEquals("1 run, 0 failed", result.getSummary());
    }

    @Test
    void testResult_formatting_test() {
        TestResult testResult = new TestResult();
        testResult.testStarted();
        testResult.testFailed();
        assertEquals("1 run, 1 failed", testResult.getSummary());
    }

    @Test
    void testResult_With_failRun()  {
        wasRun = new WasRun("testMethodWithException");
        TestResult result = new TestResult();
        wasRun.run(result);
        assertEquals("1 run, 1 failed", result.getSummary());
    }

    @Test
    void testSuite_multiple()  {
        TestSuite testSuite = new TestSuite();
        testSuite.add(new WasRun("testMethodWithException"));
        testSuite.add(new WasRun("testMethod"));
        testSuite.add(new WasRun("testMethod"));
        testSuite.add(new WasRun("testMethod"));
        TestResult result = new TestResult();
        testSuite.run(result);
        assertEquals("4 run, 1 failed", result.getSummary());
    }

    @Test
    void testSuite_multiple_static_ver()  {
        TestSuite testSuite2 = new TestSuite();

        TestSuite testSuite = WasRun.suite();

        TestResult result = new TestResult();

        testSuite2.add(new WasRun("testMethod"));
        testSuite2.add(testSuite);

        testSuite2.run(result);
        assertEquals("5 run, 1 failed", result.getSummary());
    }

    @Test
    void 소문자로시작하는_testXX_만_동작() {
        TestSuite testSuite = new TestSuite();
        testSuite.add(new WasRun("testMethodWithException"));
        testSuite.add(new WasRun("testMethod"));
        testSuite.add(new WasRun("testMethod"));
        testSuite.add(new WasRun("testMethod"));
        TestResult rs = new TestResult();
        testSuite.run(rs);
        assertEquals("5 run, 1 failed", rs.getSummary());
    }
}
