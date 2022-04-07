public class StringCalculator {
    private final String defaultSeparator=",";

    public int add(String input) {
        if (input.isEmpty()) return 0;
        int firstSeparator = firstSeparatorIndex(input);
        if (firstSeparator == -1) return ignoreNotIntegerNumbers(input);
        String[] splitInput = input.split(defaultSeparator);
        return ignoreNotIntegerNumbers(splitInput[0]) + add(splitInput[1]);
    }

    private int firstSeparatorIndex(String input) {
        return input.indexOf(defaultSeparator);
    }

    private int ignoreNotIntegerNumbers(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }


}
