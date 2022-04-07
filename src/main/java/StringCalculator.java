public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) return 0;
        return ignoreNotIntegerNumbers(input);
    }

    private int ignoreNotIntegerNumbers(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            return 0;
        }
    }


}
