
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

    public static final String IPV4_PATTERN =
            "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
                    "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
                    "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
                    "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";

    public static final String EXTRACT_PATTERN = "\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b";

    private static final Pattern extract_pattern = Pattern.compile(EXTRACT_PATTERN);
    private static final Pattern valid_pattern = Pattern.compile(IPV4_PATTERN);

    public static String getIpAddress(String text) {
            Matcher matcher = extract_pattern.matcher(text);
            if (matcher.find()) {
                Matcher valid_matcher = valid_pattern.matcher(matcher.group());
                if (valid_matcher.matches())
                    return valid_matcher.group();
            }

            return "";
    }
}