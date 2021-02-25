package xunit;

public class WasRun extends TestCase {

    public String log = "";

    public WasRun(String name) {
        super(name);
    }

    public void testMethod() {
        log += " testMethod";
    }

    public void testMethodWithException() throws Exception {
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
