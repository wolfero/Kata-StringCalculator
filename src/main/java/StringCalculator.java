public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) return 0;
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            return 0;
        }
    }
}
