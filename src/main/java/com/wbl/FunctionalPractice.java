package com.wbl;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FunctionalPractice {

    public <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> function) {

        Map<T, R> result = new HashMap<>();
        for (T t : list) {
            result.put(t, function.apply(t));
        }
        return result;

    }
    public Integer getLength(String str) {
        return str.length();
    }




    public static void main (String [] args){

        Function<String, Integer> function = x -> x.length(); // functional interface takes lambda expression

        Integer lengthmethod = function.apply("Good Morning");// applies lambda expression
        System.out.println(lengthmethod);

       FunctionalPractice obj = new FunctionalPractice();
        List <String> list = Arrays.asList("Have","a","nice","day");

        Map <String ,Integer> map = obj.convertListToMap(list, x-> x.length()); // list to map and getting length by lambda expression
        System.out.println(map);

        Map<String ,Integer> map1 = obj.convertListToMap(list,obj::getLength);// list to map and getting length using method reference
        System.out.println("********************************************");
        // Using Predicate functional interface which checks a condition and return boolean

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> collect = list1.stream().filter(x -> x > 5).collect(Collectors.toList()); // filter uses predicate as argument

        System.out.println(collect);
        Predicate<Integer> noGreaterThan5 = x -> x > 5;
        Predicate<Integer> lessThan = x -> x < 9;


        List<Integer> collect1 = list1.stream().filter(noGreaterThan5).collect(Collectors.toList());// filter uses predicate functional interface method
        System.out.println(collect1);

        List<Integer> collect2 = list1.stream().filter(noGreaterThan5.and(lessThan)).collect(Collectors.toList());// filter uses predicate functional interface method
        System.out.println(collect2);

        System.out.println("************************");

        UnaryOperator<Integer> unaryfunc = x -> x * 5;

        Integer result = unaryfunc.apply(2);
        System.out.println(result);


    }
}
