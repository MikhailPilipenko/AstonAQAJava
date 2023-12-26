import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static int convert(String str) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        String result = "";

        while (matcher.find()) {
            result += matcher.group();
        }

        return Integer.parseInt(result);
    }
}
