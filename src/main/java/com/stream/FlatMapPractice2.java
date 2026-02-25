package com.stream;

import java.util.Arrays;
import java.util.List;

public class FlatMapPractice2 {
    public static void main(String[] args) {

        //demo try out
        String str = "Get all characters from all words";
        String[] str1 = str.split(" ");


        // Problem 1: Get all individual words
        List<String> sentences = Arrays.asList(
                "Hello World",
                "Java Streams",
                "Practice Makes Perfect"
        );

        // TODO: Split each sentence and get all words in a single list
        // Expected: [Hello, World, Java, Streams, Practice, Makes, Perfect]
        // Hint: Use .split(" ") to split a string into words
        List<String> allWords = sentences.stream().flatMap(s->Arrays.stream(s.split(" "))).toList();
        System.out.println(allWords);


        // Problem 2: Get all individual characters
        List<String> words = Arrays.asList("Cat", "Dog", "Bird");

        // TODO: Get all characters from all words
        // Expected: [C, a, t, D, o, g, B, i, r, d]
        // Hint: word.split("") gives you an array of characters
        List<String> allChars = words.stream().flatMap(word -> Arrays.stream(word.split(""))).toList();
        System.out.println(allChars);


        // Problem 3: Convert to uppercase and flatten
        List<String> phrases = Arrays.asList(
                "java python",
                "javascript ruby"
        );
        List<String> toUpperCase = phrases.stream().flatMap(s->Arrays.stream(s.split(" "))).map(String::toUpperCase).toList();
        System.out.println(toUpperCase);

        // TODO: Split each phrase, convert each word to uppercase, collect to list
        // Expected: [JAVA, PYTHON, JAVASCRIPT, RUBY]

    }
}

