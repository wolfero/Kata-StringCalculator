import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public int add(String expression) {
        if (expression.isEmpty()) return 0;

        expression = extractExpression(expression);
        String[] splitInput = expression.split(separator);
        String firstNumber = splitInput[0];
        String[] rest = Arrays.copyOfRange(splitInput, 1, splitInput.length);
        return ignoreNotIntegerNumbers(firstNumber) + sum(rest);
    }

    private String extractExpression(String input) {
        if (input.startsWith("//")) {
            String[] storage = input.split("\n");
            selectCustomSeparator(storage);
            input = storage[1];
        }
        return input;
    }

    private String separator = "[,\\n]";
    private void selectCustomSeparator(String[] storage) {
        separator = storage[0].substring(storage.length);
        if (separator.matches("\\[(.+)\\]")) {
            separator = separator.substring(1, separator.length() - 1);
            selectMultipleSeparators();
        }
    }

    private void selectMultipleSeparators() {
        int toSplitSeparators = separator.indexOf("][");
        if (toSplitSeparators != -1) {
            String firstSeparator = separator.substring(0, toSplitSeparators);
            separator = firstSeparator + "|" + separator.substring(toSplitSeparators + 2);
        }
    }

    List<String> negativeNumbers = new ArrayList<>();
    private int ignoreNotIntegerNumbers(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < 0) {
                negativeNumbers.add(input);
                return 0;
            }
            return checkIfIsGreaterThanThousand(number);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private int checkIfIsGreaterThanThousand(int number) {
        if (number > 1000) return 0;
        return number;
    }

    private int sum(String[] restInput) {
        String firstNumber = restInput[0];
        if (restInput.length == 1) {
            int number = ignoreNotIntegerNumbers(firstNumber);
            if (negativeNumbers.isEmpty()) return number;

            throwException();
        }
        String[] rest = Arrays.copyOfRange(restInput, 1, restInput.length);
        return ignoreNotIntegerNumbers(firstNumber) + sum(rest);
    }

    private void throwException() {
        String messageNumbers = String.join(",",negativeNumbers);
        String message = "Negatives not allowed: "+messageNumbers;
        throw new IllegalArgumentException(message);
    }
}
