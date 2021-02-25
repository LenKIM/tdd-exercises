package xunit;

import java.lang.reflect.Method;

public class TestCase {
    protected final String name;

    public TestCase(String name) {
        this.name = name;
    }

    public TestResult run(TestResult result) {
        result.testStarted();

        setUp();
        try {
            Method method = getClass().getMethod(name);
            method.invoke(this);
        } catch (Exception ignored) {
            result.testFailed();
        }
        tearDown();

        return result;
    }

    protected void tearDown() {

    }

    protected void setUp() {

    }
}
