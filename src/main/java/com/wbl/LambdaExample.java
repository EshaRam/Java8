package com.wbl;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaExample {
    interface StringFunction {
        String run(String str);
    }
    public static void printFormatted(String str, StringFunction format) {
        String result = format.run(str);
        System.out.println(result);
    }
    @FunctionalInterface
    interface Example{
         int multiply(int a);
    }
    @FunctionalInterface
    interface Example2{
        String methodEx(String s1, String s2);
    }
    interface Example3{
        int run(String str);
    }
    public int methodref(String s){
       int res= (s.length());
       return res;
    }

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(3);
        list.add(21);
        list.add(8);
        list.add(26);
        list.add(30);

        //using consumer interface for lambda expression it takes argument and returns void
        Consumer<Integer> method = (x) -> { System.out.println(x); };
        list.forEach( method );
        System.out.println("--------------------------------");

        // using stringfunction interface
        StringFunction exclaim = (s) -> s + "!"; // with lambda expression
        StringFunction ask = (s) -> s + "?";
        printFormatted("Hello", exclaim);
        printFormatted("Hello", ask);

        // method reference for static method of a class
        BiConsumer<String, StringFunction> bi = LambdaExample::printFormatted;
        StringFunction say = (s)->s+"8";
        bi.accept("java",say);
        System.out.println("==========================");

        // calling a method using functional interface as method reference
        LambdaExample ls = new LambdaExample(); // to use method reference we need to create object
        Example3  ex = ls::methodref; // method reference using interface
        System.out.println(ex.run("Java"));
        System.out.println("============================");

        //using functional interface that takes one parameter
        Example result = (num) -> num*2;
        System.out.println(result.multiply(3));

        //using functional interface that takes two parameter

        Example2 result1 = ((s1, s2) -> s1+s2);
        System.out.println(result1.methodEx("Good","evening"));



    }



}
