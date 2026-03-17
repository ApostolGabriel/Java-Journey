package chapter1;

public class UtilityClass {

    // suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }
    public static final int NUMBER = 5;
}
