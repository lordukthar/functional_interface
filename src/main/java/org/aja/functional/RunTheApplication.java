package org.aja.functional;

import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class RunTheApplication
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        RunTheApplication app = new RunTheApplication();
        app.init();
    }

    private void init() {
        Function<String, String> toUpper = String::toUpperCase;
        Function<String, String> toLower = String::toLowerCase;


        Mather m = new Mather();
        Function<Integer, String> u = m.acceptiontFunctionReturnFunction(toUpper, "Alpha");
        System.out.println(u.apply(4));
        Function<Integer, String> l = m.acceptiontFunctionReturnFunction(toLower, "Charlie");
        System.out.println(l.apply(2));

        //Same result
        System.out.println(m.acceptiontFunctionReturnString(toUpper, "Alpha", 4));
        System.out.println(m.acceptiontFunctionReturnString(toLower, "Charlie", 2));

        //Same result
        System.out.println(m.toUpper("Alpha").apply(4));
        System.out.println(m.toLower("Charlie").apply(2));

    }
}
