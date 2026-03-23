package chapter1;

public class Elvis {
// public final field approach
//    public static final Elvis INSTANCE = new Elvis();
    private static final Elvis INSTANCE = new Elvis();

    private Elvis(){}

    // static factory approach
    public static Elvis getInstance() {
        return INSTANCE;
    }

    // preserve singleton property for serialization
    private Object readResolve() {
        return INSTANCE;
    }
}
