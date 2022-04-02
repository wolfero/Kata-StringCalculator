public class MyBoolean {
    private final boolean state;

    public MyBoolean(boolean validatedState) {
        state = validatedState;
    }

    public boolean state() {
        return state;
    }
}
