public class StringCalculator {
    private final String separator = ",|\n";
    private final int zero = 0;

    public int sumElements(String givenText) {
        if (isEmpty(givenText)) return zero;
        return doSum(separateElements(givenText));
    }

    private int doSum(String[] separateElements) {
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
        return givenText.split(separator);
    }

    private boolean isEmpty(String givenText) {
        MyBoolean myBoolean = new MyBoolean(givenText.isEmpty());
        return myBoolean.state();
    }
}