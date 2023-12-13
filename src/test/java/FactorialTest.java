import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialTest {
    @DataProvider
    public Object[][] getTestData(){
        return new Object[][] {
                {1, 1}, {2, 2}, {3, 6}, {4, 24}, {5, 120}
        };
    }

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(Lesson_12_testng.getFactorial(0), 1);
    }

    @Test (dataProvider = "getTestData")
    public void testFactorialOfPositiveNumber(int n, int m) {
        Assert.assertEquals(Lesson_12_testng.getFactorial(n), m);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        Lesson_12_testng.getFactorial(-3);
    }
}
