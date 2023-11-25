import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppData {
    private String[] header;
    private int[][] data;

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public static void save(AppData data) throws IOException {
        File file = new File("data.csv");
        PrintWriter pw = new PrintWriter(new FileWriter(file));

        pw.println(String.join(";", data.header));
        for (int[] row: data.data) {
            pw.println(String.join(";", Arrays.stream(row).mapToObj(String::valueOf).toArray(String[]::new)));
        }
        pw.close();
    }

    public static void load(AppData data) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data.csv"));
        List<String> rows = new ArrayList<>();
        String line;

        while((line = br.readLine()) != null) {
            rows.add(line);
        }

        data.header = rows.get(0).split(";");
        data.data = new int[rows.size() - 1][data.header.length];
        for (int i = 1; i < rows.size(); i++) {
            String[] values = rows.get(i).split(";");
            for (int j = 0; j < values.length; j++) {
                data.data[i - 1][j] = Integer.parseInt(values[j]);
            }
        }
        br.close();
    }
}
