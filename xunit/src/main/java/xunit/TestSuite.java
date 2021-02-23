package xunit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {

    List<TestCase> tests = new ArrayList<>();

    public void add(TestCase testMethod) {
        tests.add(testMethod);

    }

    // 콜렉팅 파라미터
    public TestResult run(TestResult result) {
        tests.forEach(t -> {
            t.run(result);
        });
        return result;
    }
}
