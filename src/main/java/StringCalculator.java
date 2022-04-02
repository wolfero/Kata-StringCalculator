public class StringCalculator {
    private final String separator = ",";
    private final int intIfError = 0;

    public int sumElements(String givenText) {
        if (isEmpty(givenText)) return intIfError;
        if (isContains(givenText)) return doSum(separateElements(givenText));
        return Integer.parseInt(givenText);
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
            return intIfError;
        }
    }

    private String[] separateElements(String givenText) {
        return givenText.split(separator);
    }

    private boolean isContains(String givenText) {
        MyBoolean myBoolean = new MyBoolean(givenText.contains(separator));
        return myBoolean.state();
    }

    private boolean isEmpty(String givenText) {
        MyBoolean myBoolean = new MyBoolean(givenText.isEmpty());
        return myBoolean.state();
    }
}
