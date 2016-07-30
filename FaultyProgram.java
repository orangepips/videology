// ISSUE: missing class declaration
public class FaultyProgram {
    // ISSUE: missing return type & "integer"
    //  is not a valid Java type
    // OLD_CODE: public static scrollDown (integer a)
    public static void scrollDown (int a)
    {
        // ISSUE: (a = 0) is a declaration not a boolean test
        // ISSUE: a ternary operator is used for making
        //  an assignment in Java
        // ISSUE: the algorithm expressed produces an infinite
        //  loop - intent is unclear so fix is not knowable
        // OLD_CODE: (a = 0) ? scrollDown(100) : scrollDown(a-1);

    }

    // ISSUE: missing return type & argument type for 'arg2'
    // ISSUE: also the expectation is probably that this is treated
    //  as "public static void main(String args...)"
    //  but this will not work where Java when given a class to start
    //  with from the command line looks for a method on
    //  that class, unless told otherwise, that matches exactly that signature.
    // OLD_CODE: main(int arg1, arg2)
    void main(int arg1, int arg2)
    {
        // ISSUE: while not wrong, the nested if block below is probably
        //  better expressed as
        //   if (arg2 < 0) {
        //      System.out.print("Too small");
        //   } else if (arg2 == 0) {
        //      System.out.print("Just right.");
        //   }
        // In addition this test does not seem to be meaningful because
        //  it does not affect program execution in any way
        // and arg2 is not used for anything else
        if (arg2 <= 0)
            if (arg2 < 0)
                // ISSUE: no "print" function and missing a terminating
                //  semicolon
                // OLD_CODE: print("Too small.")
                System.out.print("Too small");
            else
                // ISSUE: no "print" function and missing a terminating
                //  semicolon
                // OLD_CODE: print("Just right.")
                System.out.print("Just right.");
        // ISSUE: no overloaded 'scrollDown' function taking an integer
        //  and String argument
        // OLD_CODE: scrollDown(arg1, "start");
        scrollDown(arg1);
    }
}
