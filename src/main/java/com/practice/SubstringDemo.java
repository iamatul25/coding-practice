package com.practice;

public class SubstringDemo {

    public static void main(String[] args) {

        //print character and their indexes
        String s = "HELLO";
        for(int i = 0; i<s.length(); i++){
           System.out.println("char at index : "+i+" is : "+s.charAt(i));
        }
        System.out.println("---___---___---");
        //print every two character substring
        int k = 2;
        for (int i=0; i<=s.length()-k; i++){
            System.out.println(s.substring(i, i+k));
        }

    }
}
