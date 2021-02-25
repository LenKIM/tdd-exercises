package xunit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {

    List<WasRun> tests = new ArrayList<>();

    public void add(WasRun test) {
        tests.add(test);
    }

    public TestResult run(){
        TestResult result = new TestResult();
        tests.forEach(t -> {
            t.run(result);
        });
        return result;
    }
}
