package com.code;

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
    }
}
