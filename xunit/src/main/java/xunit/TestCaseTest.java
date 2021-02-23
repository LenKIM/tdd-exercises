package xunit;

public class TestCaseTest extends TestCase {

    WasRun wasRun;

    public TestCaseTest(String name) {
        super(name);
    }

    @Override
    public void setUp() {
        wasRun = new WasRun("testMethod");
    }

    public void testRunning(){
        Assert.assertEqauls(false, wasRun.wasRun);
        wasRun.run();
        Assert.assertEqauls(true, wasRun.wasRun);
    }

    public void testSetUp(){
        Assert.assertEqauls(false, wasRun.wasSetUp);
        wasRun.run();
        Assert.assertEqauls(true, wasRun.wasSetUp);
    }
}
