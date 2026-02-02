package com.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
    }
}
