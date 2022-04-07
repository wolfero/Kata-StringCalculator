import java.util.Arrays;

public class StringCalculator {
    private String separator = "[,\\n]";

    public int add(String input) {
        if (input.isEmpty()) return 0;
        if(input.startsWith("//")){
            String[] splitedInput=input.split("\n");
            separator=splitedInput[0].substring(splitedInput.length);
            input=splitedInput[1];
        }
        String[] splitInput = input.split(separator);
        String firstNumber = splitInput[0];
        String[] rest = Arrays.copyOfRange(splitInput, 1, splitInput.length);
        return ignoreNotIntegerNumbers(firstNumber) + sum(rest);
    }

    private int ignoreNotIntegerNumbers(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private int sum(String[] restInput) {
        String firstNumber = restInput[0];
        if (restInput.length == 1) return ignoreNotIntegerNumbers(firstNumber);
        String[] rest = Arrays.copyOfRange(restInput, 1, restInput.length);
        return ignoreNotIntegerNumbers(firstNumber) + sum(rest);
    }


}
