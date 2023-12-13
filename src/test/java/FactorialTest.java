import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    @Test
    public void testFactorialOfZero() {
        Assertions.assertEquals(Lesson_12_junit_5.getFactorial(0), 1);
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "3, 6", "4, 24", "5, 120"})
    public void testFactorialOfPositiveNumber(int n, int m) {
        Assertions.assertEquals(Lesson_12_junit_5.getFactorial(n), m);
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                Lesson_12_junit_5.getFactorial(-3));
    }
}
