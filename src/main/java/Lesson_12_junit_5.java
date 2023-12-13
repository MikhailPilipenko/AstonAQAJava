public class Lesson_12_junit_5 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, -5};

        for (int i : numbers) {
            try {
                System.out.println("Factorial " + i + "! = " + getFactorial(i));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + i);
            }
        }
    }

    public static int getFactorial(int f) {
        if (f < 0) {
            throw new IllegalArgumentException("Used negative number: ");
        }

        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }

        return result;
    }
}
