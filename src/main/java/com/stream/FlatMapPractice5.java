package com.stream;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class FlatMapPractice5 {
    @Getter
    static class Order {
        int orderId;
        List<Item> items;

        Order(int orderId, List<Item> items) {
            this.orderId = orderId;
            this.items = items;
        }

    }

    @Getter
    static class Item {
        String name;
        int price;

        Item(String name, int price) {
            this.name = name;
            this.price = price;
        }

    }

    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order(1, Arrays.asList(
                        new Item("Laptop", 50000),
                        new Item("Mouse", 500)
                )),
                new Order(2, Arrays.asList(
                        new Item("Keyboard", 1500),
                        new Item("Monitor", 15000),
                        new Item("Mouse", 500)
                )),
                new Order(3, Arrays.asList(
                        new Item("Laptop", 50000)
                ))
        );

        // Problem 1: Get all item names from all orders
        // TODO: Use flatMap
        List<String> itemList = orders.stream().flatMap(e -> e.getItems().stream()).map(Item::getName).toList();
        System.out.println(itemList);


        // Problem 2: Get unique item names
        // TODO: flatMap + distinct
        List<String> uniqueItemList = orders.stream().flatMap(e -> e.getItems().stream()).map(Item::getName).distinct().toList();
        System.out.println(uniqueItemList);


        // Problem 3: Calculate total value of all items across all orders
        // TODO: flatMap to get all items, map to price, sum
        // Hint: Use .mapToInt(Item::getPrice).sum()
        var sum = orders.stream().flatMap(o -> o.getItems().stream()).mapToInt(Item::getPrice).sum();
        System.out.println(sum);


        // Problem 4: Get all items with price > 1000
        // TODO: flatMap to get items, filter by price, collect to list
        var list = orders.stream().flatMap(o -> o.getItems().stream()).filter(i -> i.getPrice() > 1000).toList();
        System.out.println(list);


        // Problem 5: Count how many times "Mouse" was ordered
        // TODO: flatMap, filter by name, count
        var mouse = orders.stream().flatMap(o -> o.getItems().stream()).filter(i -> i.getName().equalsIgnoreCase("Mouse")).count();
        System.out.println(mouse);

    }

}
