import java.math.BigDecimal;

public class AddTwoNumbers {
    public static void main(String... args) {
        System.out.println(add(args[0], args[1]));
    }

    // Relies upon BigDecimal's built in number parsing to convert to an appropriate value
    // this handles sign, integers, fractions and exponents
    // see http://docs.oracle.com/javase/7/docs/api/java/math/BigDecimal.html#BigDecimal(java.lang.String)
    public static String add(String a, String b) {
        return new BigDecimal(a).add(new BigDecimal(b)).toString();
    }
}
