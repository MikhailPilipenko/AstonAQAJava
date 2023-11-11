public class Lesson_2 {
    public static void main(String[] args) {
        System.out.println("printThreeWords()");
        printThreeWords();
        System.out.println("\ncheckSumSign()");
        checkSumSign(2, 6);
        checkSumSign(2, -3);
        System.out.println("\nprintColor()");
        printColor(-1);
        printColor(0);
        printColor(1);
        printColor(99);
        printColor(100);
        printColor(101);
        System.out.println("\ncompareNumbers()");
        compareNumbers(12, 4);
        compareNumbers(14, 14);
        compareNumbers(3, 5);
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign(int a, int b) {
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
