public class StringCalculator {
    public int sumElements(String givenText) {
        if (isEmpty(givenText)) return 0;
        return Integer.parseInt(givenText);
    }

    private boolean isEmpty(String givenText) {
        MyBoolean myBoolean = new MyBoolean(givenText.isEmpty());
        return myBoolean.state();
    }
}
