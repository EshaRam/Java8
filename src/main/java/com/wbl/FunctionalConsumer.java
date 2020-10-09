package com.wbl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalConsumer {

    static <T> void foreach(List<T> list, Consumer<T> consumer){

        for(T t: list){
            consumer.accept(t);

        }
    }

    public static void main( String []args){

        List<Integer> list = Arrays.asList(2,3,5,6);

        foreach(list,(Integer x)-> System.out.println(x)); // calling foreach method directly

        System.out.println("implementing consumer interface");
        Consumer<Integer> consumer = (Integer x)-> System.out.println(x); // consumer interface doesn't return anything. it returns void.
        foreach(list,consumer);
        System.out.println("passing consumer as argument");
        foreach(list,(Integer x)-> System.out.println(x*2));

        Supplier<LocalDateTime> s = () -> LocalDateTime.now(); // supplier interface takes no argument and gives a result
        LocalDateTime time = s.get();
        System.out.println(time);

    }




}
