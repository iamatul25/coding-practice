package com.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Substring1 {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String s = scan.next();
//        int k = scan.nextInt();
//        scan.close();
        String s = "welcometojava";
        Integer k = 3;
        System.out.println(getSmallestAndLargest(s, k));
    }

    public static String getSmallestAndLargest(String s, Integer k){

        ArrayList<String> list = new ArrayList<>();
        for (int start=0;start<=s.length()-k;start++){
            int end = start+k;
            list.add(s.substring(start,end));
        }
        Collections.sort(list);
        list.forEach(System.out::println);
        String smallest = list.get(0);
        String largest = list.get(list.size() - 1);
        return smallest + "\n" + largest;
    }
}
