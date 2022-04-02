import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
    private final StringBuilder regex = new StringBuilder("\\n,");
    private final StringBuilder resutl = new StringBuilder();

    public int add(String input) {
        if (input.startsWith("//")) {
            regex.append(input, input.indexOf("//"), input.indexOf("\n"));
            resutl.append(input.substring(input.indexOf("\n")).trim());
        } else {
            resutl.append(input);
        }
        return sumElements();
    }

    private int sumElements() {
        return separateElements()
                .filter(this::isNumber)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private boolean isNumber (String element) {
        try {
            Integer.parseInt(element);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Stream<String> separateElements() {
        return Arrays.stream(resutl.toString().split("[" + regex + "]"))
                .map(String::strip)
                .filter(element -> !element.isEmpty());

    }
}