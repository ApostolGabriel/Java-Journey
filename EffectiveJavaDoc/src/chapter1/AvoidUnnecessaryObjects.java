package chapter1;

import java.util.regex.Pattern;

/**
 * 1.6 Avoid creating unnecessary objects
 * <p>
 *     Avoid creating unnecessary objects by using static factory methods in preference to constructors on mutable objects.
 * </p>
 * <p>
 *     Prefer primitives to boxed primitives.
 * </p>
 */
public class AvoidUnnecessaryObjects {

    public static final String ROMAN_NUMERAL_REGEX = "^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";
    private static Pattern ROMAN_NUMERAL_PATTERN = Pattern.compile(ROMAN_NUMERAL_REGEX);

    public static void main(String[] args) {
        // DON'T DO THIS
        String s = new String("bikini");

        // improved version
        String sImp = "bikini";

        // don't do this
        System.out.println(isRomanNumeral("MXCVII"));

        // do this
        System.out.println(isRomanNumeralImproved("XVIII"));
    }

    private static boolean isRomanNumeral(String s) {
        return s.matches(ROMAN_NUMERAL_REGEX);
    }

    // 6.5 times faster
    private static boolean isRomanNumeralImproved(String s) {
        return ROMAN_NUMERAL_PATTERN.matcher(s).matches();
    }

    // program constructs 2^31 unnecessary Long instances - each time sum has a new value, a new Long object is created
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}
