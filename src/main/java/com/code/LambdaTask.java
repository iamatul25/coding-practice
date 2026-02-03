package com.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public class LambdaTask {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Task 1: Runnable ===");
        // TODO: Convert this Runnable to lambda
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("r1 Thread is running: " + Thread.currentThread().getName());
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
        Thread.sleep(100); // Wait for thread to complete

        //lambda implementation of runnable
        Runnable r2 = ()-> System.out.println("r2 Thread is running: " + Thread.currentThread().getName());
        Thread t2 = new Thread(r2);
        t2.start();
        Thread.sleep(100);

        System.out.println("\n=== Task 2: Comparator ===");
        // TODO: Convert this Comparator to lambda
        List<String> names = Arrays.asList("Rajesh", "Priya", "Amit", "Ananya", "Vikram");
        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };
        names.sort(lengthComparator);
        System.out.println("Sorted by length: " + names);
        names.sort(Comparator.comparing(String::length));

        System.out.println("\n=== Task 3: Callable ===");
        // TODO: Convert this Callable to lambda
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 42 * 2;
            }
        };
        System.out.println("Callable result: " + callable.call());
        Callable <Integer> c = ()-> 52 * 2;
        System.out.println("Callable result: " + c.call());

        MyInterface m = (a,b)-> a*b;
        System.out.println(m.doSomething(3,4));

//        StringProcessor sp = String::toUpperCase;
        StringProcessor sp = (s)->s.toUpperCase();
        System.out.println(sp.process("hello world"));

    }
}
