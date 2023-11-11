import java.util.Arrays;

public class Lesson_3 {
    public static void main(String[] args) {
        System.out.println("task 1");
        System.out.println(checkSumBetweenTenAndTwenty(5, 4));
        System.out.println(checkSumBetweenTenAndTwenty(5, 5));
        System.out.println(checkSumBetweenTenAndTwenty(5, 6));
        System.out.println(checkSumBetweenTenAndTwenty(15, 4));
        System.out.println(checkSumBetweenTenAndTwenty(15, 5));
        System.out.println(checkSumBetweenTenAndTwenty(15, 6));
        System.out.println("\ntask 2");
        printStringNumberOfTimes("ASTON", 3);
        System.out.println("\ntask 3");
        isNumberPositive(-1);
        isNumberPositive(0);
        isNumberPositive(1);
        System.out.println("\ntask 4");
        System.out.println(checkIsNumberPositive(-1));
        System.out.println(checkIsNumberPositive(0));
        System.out.println(checkIsNumberPositive(1));
        System.out.println("\ntask 5");
        System.out.println(isYearLeap(1900));
        System.out.println(isYearLeap(1996));
        System.out.println(isYearLeap(2000));

        System.out.println("\ntask 6");
        int[] arr6 = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Original array: " + Arrays.toString(arr6));

        for (int i = 0; i < arr6.length; i++) {
            if(arr6[i] == 0) {
                arr6[i] = 1;
            } else {
                arr6[i] = 0;
            }
        }

        System.out.println("Changed array: " + Arrays.toString(arr6));

        System.out.println("\ntask 7");
        int[] arr7 = new int[100];

        for (int i = 0; i < arr7.length; i++) {
            arr7[i] = i + 1;
        }

        System.out.println("Array 100 numbers: \n" + Arrays.toString(arr7));

        System.out.println("\ntask 8, 9");
        int[] arr8 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Original array: " + Arrays.toString(arr8));

        for (int i = 0; i < arr8.length; i++) {
            if(arr8[i] < 6) {
                arr8[i] *= 2;
            }
        }

        System.out.println("Changed array: " + Arrays.toString(arr8));

        System.out.println("\ntask 10");
        int[][] arr10 = new int[10][10];

        for (int i = 0; i < arr10.length; i++) {
            for (int j = 0; j < arr10[i].length; j++) {
                if (i == j || i + j == arr10.length - 1) {
                    arr10[i][j] = 1;
                } else {
                    arr10[i][j] = 0;
                }
            }
        }

        for (int[] ints: arr10) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println("\ntask 11");
        System.out.println(Arrays.toString(getArray(7, 9)));
    }

    public static boolean checkSumBetweenTenAndTwenty(int a, int b) {
        int sum = a + b;

        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void printStringNumberOfTimes(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    public static void isNumberPositive(int a) {
        if (a >= 0) {
            System.out.println("Number " + a + " is positive");
        } else {
            System.out.println("Number " + a + " is negative");
        }
    }

    public static boolean checkIsNumberPositive(int a) {
        if (a >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isYearLeap(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] getArray(int len, int initialValue) {
        int[] arr = new int[len];

        Arrays.fill(arr, initialValue);

        return arr;
    }
}
