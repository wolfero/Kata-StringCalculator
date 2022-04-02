import java.util.Arrays;

public class StringCalculator {
    public final String separator = ",";

    public int sumElements(String givenText) {
        if (isEmpty(givenText)) return 0;
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
        return Integer.parseInt(element);
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
