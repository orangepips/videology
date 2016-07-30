/**
 * Shamelessly stolen from http://javarevisited.blogspot.com/2013/05/how-to-check-if-integer-number-is-power-of-two-example.html
 *
 * Note this could also be done with brute force methods like multiplying two by itself recursively or in a loop,
 * but bit shifting is generally faster.
 *
 * Recall that zero - i.e. "0" - is NOT a power of 2.
 */
public class PowerOfTwo {
    /*
     * checking if number is power of 2 using bit shift operator in java
     * e.g. 4 in binary format is "0000 0000 0000 0000 0000 0000 0000 0100";
     * and -4 is                  "1111 1111 1111 1111 1111 1111 1111 1100";
     * and 4&-4 will be           "0000 0000 0000 0000 0000 0000 0000 0100"
     */
    public static boolean isPositiveNegative(int number) {
        return ((number > 0) && (number & -number) == number);
    }

    /* See: http://www.exploringbinary.com/ten-ways-to-check-if-an-integer-is-a-power-of-two-in-c/
     * x	        x – 1	    x & (x – 1)
     * 00000001	    00000000	00000000
     * 00000100	    00000011	00000000
     * 00010000	    00001111	00000000
     */
    public static boolean isMinusOne(int number)
    {
        return ((number > 0) && (number & (number - 1)) == 0);
    }

    public static void main(String... args) {
        for (int x = 0; x <= 100; x++) {
            System.out.println(x + ":\t" + isPositiveNegative(x) + "\t" + isMinusOne(x));
        }
    }
}
