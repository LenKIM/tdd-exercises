package xunit;

public class WasRun extends TestCase {

    public boolean isRun = false;

    public WasRun(String name) {
        super(name);
    }

    public void testMethod() {
        this.isRun = true;
    }
}
