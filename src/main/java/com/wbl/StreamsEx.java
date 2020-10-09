package com.wbl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsEx {

    public static void main(String [] args){

        ArrayList <Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(8);
        list.add(11);
        list.add(10);
        list.add(12);
        System.out.println(list);
        List<Integer> l = list.stream().map(i->i+5).filter(i->i%2==1).limit(4).skip(1).collect(Collectors.toList());
        System.out.println(l);
        l.forEach(System.out::println);
        System.out.println("--------------------------------------");

        int sum  = list.stream().reduce(0,(a, b) -> a + b);
        System.out.println("sum =" + sum);
        System.out.println("--------------------------------------");

        List<Integer> l1= Arrays.asList(1,4,3,8,7,9,6);
        Optional<Integer> first = l1.stream().filter(x->x>2).findFirst();
        System.out.println(first);
        Optional<Integer> any = l1.stream().filter(x->x>4).findAny();
        System.out.println(any);
        System.out.println("--------------------------------------");

        List<String> list2 = new ArrayList<String>();
        list2.add("Esha");
        list2.add("Theetha");
        list2.add("Anu");
        list2.add("Vishnu");

        List<String> l2 = list2.stream().sorted().collect(Collectors.toList());
        System.out.println(l2);

        List<String> comp = list2.stream().sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
        System.out.println(comp);
        boolean m1 = list2.stream().anyMatch(s -> s.equalsIgnoreCase("esha"));
        System.out.println(m1);
        boolean m = list2.stream().noneMatch(s -> s.startsWith("A"));
        System.out.println(m);




    }
}
