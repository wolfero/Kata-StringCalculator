public class StringCalculator {
    public final String separator = ",";

    public int sumElements(String givenText) {
        if (isEmpty(givenText)) return 0;
        if (isContains(givenText)) return doSum(separateElements(givenText));
        return Integer.parseInt(givenText);
    }

    private int doSum(String[] separateElements) {
        return Integer.parseInt(separateElements[0]) + Integer.parseInt(separateElements[1]);
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
