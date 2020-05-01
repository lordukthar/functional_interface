package org.aja.functional;

import java.util.function.Function;

public class Mather {


    //Accept a function and return a function
    Function<Integer, String> acceptiontFunctionReturnFunction(Function<String/*input*/, String /*output*/> lambda, String name) {
        String result = lambda.apply(name);//This will do the operation toUpper or toLower

        return count ->
                result.repeat(count);//This will repeat the word the nummber of times we do a call to apply (2 and 4)

        //or method reference
        //return result::repeat;//This will repeat the word the nummber of times we do a call to apply (2 and 4)

    }

    // //Accept a function and return a String
    String acceptiontFunctionReturnString(Function<String/*input*/, String /*output*/> lambda, String name, Integer count) {
        String result = lambda.apply(name);//This will do the operation toUpper or toLower
        return result.repeat(count);//This will repeat the word the nummber of times we do a call to apply (2 and 4)
    }

    // Old fashioned, one method per operation
    Function<Integer, String> toUpper(String name) {
        String toUpper = name.toUpperCase();
        return toUpper::repeat;
    }

    // Old fashioned, one method per operation
    Function<Integer, String> toLower(String name) {
        String toLower = name.toLowerCase();
        return toLower::repeat;
    }

}
