package xunit;

public class XUnitTest {

    public static void main(String[] args) {
//        WasRun wasRun = new WasRun("testMethod");
//        System.out.println(wasRun.wasRun); // false
//        wasRun.run();
//        System.out.println(wasRun.wasRun); // true

        new TestCaseTest("testRunning").run();
        new TestCaseTest("testSetUp").run();
    }
}
