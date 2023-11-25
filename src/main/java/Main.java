import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        AppData data1 = new AppData();
        data1.setHeader(new String[]{"Value 1", "Value 2", "Value 3"});
        data1.setData(new int[][]{{100, 200, 123}, {300, 400, 500}});
        AppData.save(data1);

        AppData data1load = new AppData();
        AppData.load(data1load);
        print(data1load);

        AppData data2 = new AppData();
        data2.setHeader(new String[]{"Value 3", "Value 4", "Value 5", "Value 6"});
        data2.setData(new int[][]{{600, 700, 323, 567}, {500, 900, 200, 456}});
        AppData.save(data2);

        AppData data2load = new AppData();
        AppData.load(data2load);
        print(data2load);
    }

    public static void print(AppData data) {
        System.out.println(Arrays.toString(data.getHeader()));
        for (int[] ints : data.getData()) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
