package org.aja.functional;

import java.util.Arrays;
import java.util.function.Function;

public class Func {


    public static void main(String...args) {
        new Func().init();
        //Function
    }

    private void init() {
        Arrays.asList("Jonas", "Aspemo", "Anders")
                .stream().forEach((x) -> System.out.println(getSize().apply(x)));
    }

    private Function<String, Integer> getSize() {
        return a -> {
            return getLength(a);
        };
    }


    private Integer getLength(String name) {
        return name.length();
    }

}
