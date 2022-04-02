import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final int zero = 0;

    public int add(String givenText) {
        if (isEmpty(givenText)) return zero;
        return sumElements(separateElements(givenText));
    }

    private int sumElements(String[] separateElements) {
        int result = 0;
        for (String element : separateElements) {
            result += parseStringToInt(element);
        }
        return result;
    }

    private int parseStringToInt(String element) {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            return zero;
        }
    }

    private String[] separateElements(String givenText) {
        if(givenText.startsWith("//")){
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(givenText);
            if (matcher.matches()){
                String separator=matcher.group(1);
                String toSplit = matcher.group(2);
                return toSplit.split(separator);
            }
        }
        return givenText.split(",|\n");
    }

    private boolean isEmpty(String givenText) {
        MyBoolean myBoolean = new MyBoolean(givenText.isEmpty());
        return myBoolean.state();
    }
}