package xunit;

public class XUnitTest {

    public static void main(String[] args) {
//        WasRun wasRun = new WasRun("testMethod");
//        System.out.println(wasRun.wasRun); // false
//        wasRun.run();
//        System.out.println(wasRun.wasRun); // true
        TestSuite suite = new TestSuite();
        suite.add(new TestCaseTest("testTemplateMethod"));
        suite.add(new TestCaseTest("testResult"));
        suite.add(new TestCaseTest("testFailedResultFormatting"));
        suite.add(new TestCaseTest("testFailedResult"));
        TestResult result = new TestResult();

        suite.run(result);
        System.out.println(result.getSummary());

//        new TestCaseTest("testSetUp").run();
    }
}
