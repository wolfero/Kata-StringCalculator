public class StringCalculator {
    public int sumElements(String givenText) {
        if (isEmpty(givenText)) return 0;
        if(givenText.contains(",")){
            String[] separatedText = givenText.split(",");
            return Integer.parseInt(separatedText[0])+Integer.parseInt(separatedText[1]);
        }
        return Integer.parseInt(givenText);
    }

    private boolean isEmpty(String givenText) {
        MyBoolean myBoolean = new MyBoolean(givenText.isEmpty());
        return myBoolean.state();
    }
}
