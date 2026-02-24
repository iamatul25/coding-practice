package com.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FlatMapPractice1 {
    public static void main(String[] args) {

        // Problem 1: Flatten this nested list
        List<List<String>> fruits = Arrays.asList(
                Arrays.asList("Apple", "Banana"),
                Arrays.asList("Orange", "Mango"),
                Arrays.asList("Grapes", "Watermelon")
        );

        // TODO: Use flatMap to get a single list of all fruits
        // Expected output: [Apple, Banana, Orange, Mango, Grapes, Watermelon]
        List<String> allFruits = fruits.stream().flatMap(List::stream).toList();
        List<String> allFruits1 = fruits.stream().flatMap(Collection::stream).toList();
        System.out.println(allFruits);


        // Problem 2: Flatten this nested list of numbers
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(10, 20),
                Arrays.asList(30, 40, 50),
                Arrays.asList(60)
        );

        // TODO: Use flatMap to get a single list of all numbers
        // Expected output: [10, 20, 30, 40, 50, 60]
        numbers.stream().flatMap(List::stream).forEach(System.out::println);


        // Problem 3: Print each fruit on a new line
        // TODO: Use flatMap and forEach to print each fruit

    }
}
