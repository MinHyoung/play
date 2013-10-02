import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {
    private static final Pattern HTTP_VERSION_PATTERN = Pattern.compile("(\\S+)/(\\d+)\\.(\\d+)");

    public static void main(String[] args) throws Exception {
        Matcher m = HTTP_VERSION_PATTERN.matcher("HTTP/1.1");
        if (m.matches()) {
            String protocolName = m.group(1);
            Integer majorVersion = Integer.parseInt(m.group(2));
            Integer minorVersion = Integer.parseInt(m.group(3));
            System.out.printf("%s/%d.%d\n", protocolName, majorVersion, minorVersion);
        }
    }
}
