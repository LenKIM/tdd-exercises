package xunit;

public class Assert {
    public static void assertEqauls(Object expected, Object actual) {
        if(!expected.equals(actual)) throw new AssertionError("expected<" + expected + "> but was < " + actual + ">");

    }
}
