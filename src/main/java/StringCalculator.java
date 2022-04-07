import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private String separator = "[,\\n]";
    List<Integer> negativeNumbers = new ArrayList<>();

    public int add(String input) {
        if (input.isEmpty()) return 0;
        input = extractContentWithoutSeparator(input);
        String[] splitInput = input.split(separator);
        String firstNumber = splitInput[0];
        String[] rest = Arrays.copyOfRange(splitInput, 1, splitInput.length);
        return ignoreNotIntegerNumbers(firstNumber) + sum(rest);
    }

    private String extractContentWithoutSeparator(String input) {
        if (input.startsWith("//")) {
            String[] storage = input.split("\n");
            extractedCustomSeparator(storage);
            input = storage[1];
        }
        return input;
    }

    private void extractedCustomSeparator(String[] storage) {
        separator = storage[0].substring(storage.length);
        if (separator.matches("\\[(.+)\\]")) {
            separator = separator.substring(1, separator.length() - 1);
            int toSplitSeparators = separator.indexOf("][");
            if (toSplitSeparators != -1) {
                String firstSeparator = separator.substring(0, toSplitSeparators);
                separator = firstSeparator + "|" + separator.substring(toSplitSeparators + 2);
            }
        }
    }

    private int ignoreNotIntegerNumbers(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < 0) {
                negativeNumbers.add(number);
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
        StringBuilder message = new StringBuilder();
        for (int negativeNumber : negativeNumbers) {
            if (message.toString().equals("")) {
                message = new StringBuilder("Negatives not allowed: " + negativeNumber);
            } else {
                message.append(", ").append(negativeNumber);
            }
        }
        throw new IllegalArgumentException(message.toString());
    }


}
