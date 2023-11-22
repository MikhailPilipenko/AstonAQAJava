public class Lesson_7 {
    public static void main(String[] args) {
        String[][] arr1 = new String[][] {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] arr2 = new String[][] {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15"}};
        String[][] arr3 = new String[][] {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "fifteen", "16"}};

        String[][][] arrays = new String[][][] {arr1, arr2, arr3};

        for (int i = 0; i < arrays.length; i++) {
            try {
                int result = getSumArrayItems(arrays[i]);
                System.out.println("The sum of array elements is " + result);
            } catch (MyArraySizeException e) {
                System.out.println("The size of array isn't 4*4");
            } catch (MyArrayDataException e) {
                System.out.println("Cannot convert array elements in int");
                System.out.println("Invalid data in cell: [" + e.i + "][" + e.j + "]");
            }
        }
    }

    public static int getSumArrayItems(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (arr.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }
}
