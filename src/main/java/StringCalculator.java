public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) return 0;
        int firstSeparator = input.indexOf(",");
        if (firstSeparator == -1) return ignoreNotIntegerNumbers(input);
        String[] splitInput = input.split(",");
        return ignoreNotIntegerNumbers(splitInput[0]) + add(splitInput[1]);
    }

    private int ignoreNotIntegerNumbers(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }


}
