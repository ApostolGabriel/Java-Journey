package chapter1;

/**
 * 1.4 Enforce noninstantiability with a private constructor
 * <p>
 *     Attempting to enforce instantiability by making a class abstract does not work. Misleads the user that the class was designed to be inherited.
 * </p>
 * <p>
 *     Use a private constructor to not instantiate a class. Cannot be instantiated or subclassed.
 * </p>
 */
public class PrivateConstructorNoninstantiability {

    public static void main(String[] args) {
//        UtilityClass util = new UtilityClass();
        System.out.println(UtilityClass.NUMBER);
    }

}
