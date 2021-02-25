package xunit;

public class WasRun extends TestCase {

    public boolean isRun = false;
    public boolean wasSetUp = false;
    public boolean tearDown = false;

    public WasRun(String name) {
        super(name);
    }

    public void testMethod() {
        this.isRun = true;
    }
    @Override
    public void setUp(){
        wasSetUp = true;
    }
    @Override
    public void tearDown(){
        tearDown = true;
    }
}
