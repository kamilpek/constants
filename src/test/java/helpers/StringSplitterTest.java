package helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringSplitterTest {

    @Test
    void testWithWhiteSpace() {
        String[] result = StringSplitter.split("test test");
        Assertions.assertArrayEquals(new String[]{"test", " test"}, result);
    }

    @Test
    void testWithMultipleWhiteSpaces() {
        String[] result = StringSplitter.split("test   test");
        Assertions.assertArrayEquals(new String[]{"test", " test"}, result);
    }

    @Test
    void testWithDash() {
        String[] result = StringSplitter.split("test-test");
        Assertions.assertArrayEquals(new String[]{"test", " test"}, result);
    }

    @Test
    void testWithMultipleDashes() {
        String[] result = StringSplitter.split("test-_-test");
        Assertions.assertArrayEquals(new String[]{"test", " test"}, result);
    }

    @Test
    void testCamelCase() {
        String[] result = StringSplitter.split("testTest");
        Assertions.assertArrayEquals(new String[]{"test", "Test"}, result);
    }

    @Test
    void testPascalCase() {
        String[] result = StringSplitter.split("TestTest");
        Assertions.assertArrayEquals(new String[]{"Test", "Test"}, result);
    }

    @Test
    void testSnakeUpperCase() {
        String[] result = StringSplitter.split("TEST_TEST");
        Assertions.assertArrayEquals(new String[]{"TEST ", "TEST"}, result);
    }

    @Test
    void testLowerCase() {
        String[] result = StringSplitter.split("testtest");
        Assertions.assertArrayEquals(new String[]{"testtest"}, result);
    }

    @Test
    void testNull() {
        String[] result = StringSplitter.split(null);
        Assertions.assertArrayEquals(new String[]{""}, result);
    }

    @Test
    void testEmptyString() {
        String[] result = StringSplitter.split("");
        Assertions.assertArrayEquals(new String[]{""}, result);
    }

    @Test
    void testSplitLines() {
        String[] result = StringSplitter.splitLines("    one\n" +
                "    two\n" +
                "    three\n" +
                "    four");
        Assertions.assertArrayEquals(new String[]{"one", "two", "three", "four"}, result);
    }

    @Test
    void testSplitLinesTabs() {
        String[] result = StringSplitter.splitLines("    one\n" +
                "\ttwo\n" +
                "\tthree\n" +
                "\tfour");
        Assertions.assertArrayEquals(new String[]{"one", "two", "three", "four"}, result);
    }
}
