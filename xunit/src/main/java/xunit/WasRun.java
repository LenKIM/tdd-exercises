package xunit;

public class WasRun extends TestCase {

    public String log = "";

    public WasRun(String name) {
        super(name);
    }

    public static TestSuite suite() {
        TestSuite testSuite = new TestSuite();
        testSuite.add(new WasRun("testMethodWithException"));
        testSuite.add(new WasRun("testMethod"));
        testSuite.add(new WasRun("testMethod"));
        testSuite.add(new WasRun("testMethod"));
        return testSuite;
    }

    public void testMethod() {
        log += " testMethod";
    }

    public void testMethodWithException() throws Exception {
        log += " testMethod";
        throw new Exception();
    }

    public void testMethod2() throws Exception {
        log += " testMethod";
        throw new Exception();
    }

    public void testMethod3() throws Exception {
        log += " testMethod";
        throw new Exception();
    }

    @Override
    public void setUp(){
        log = "setUp";
    }
    @Override
    public void tearDown(){
        log += " tearDown";
    }
}
