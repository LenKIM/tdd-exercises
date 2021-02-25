package xunit;

public class TestResult {
    int runCount = 0;
    int failCount = 0;

    public void testStarted() {
        runCount++;
    }

    public String getSummary() {

        return runCount + " run, " + failCount + " failed";
    }

    public void testFailed() {
        failCount++;
    }
}
