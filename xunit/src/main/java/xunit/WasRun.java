package xunit;

public class WasRun extends TestCase {
    public String log;

    public WasRun(String name) {
        super(name);
    }

    public void testMethod() {
        log += " testmethod";
    }

    @Override
    public void setUp() {
        log = "SetUp";
    }

    @Override
    public void tearDown() {
        log += " tearDown";
    }

    public void testBrokenMethod(){
        throw new AssertionError();
    }
}
