package ru.kpfu.itis.kirillakhmetov.work.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        // 1
//        int[] arr = {15, 17, 13, 52, 100, 68, 89, 63, 77, -1, -50, 61};
//
//        int sum = Arrays.stream(arr).sum();
//
//        System.out.println(sum);

//        // 2
//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person("Кирилл", 22));
//        persons.add(new Person("Руслан", 18));
//        persons.add(new Person("Сайид", 17));
//        persons.add(new Person("Даня", 20));
//        persons.add(new Person("Леха", 25));
//
//        persons.stream().filter(person -> person.getAge() > 18)
//                .sorted(Comparator.comparingInt(Person::getAge))
//                .map(Person::getName)
//                .forEach(System.out::println);

//        // 3
//        List<String> strings = new ArrayList<>();
//        strings.add("кирилл");
//        strings.add("руслан");
//        strings.add("даня");
//        strings.add("сайид");
//        strings.add("лёха");
//        strings.add("дима");
//
//        strings.stream().map(String::toUpperCase).sorted(String::compareTo).forEach(System.out::println);

//        // 4
//        int[] arr = {15, 17, 13, 52, 100, 68, 89, 63, 77, -1, -50, 61};
//        int minInt = Arrays.stream(arr).map(x -> x * x).min().orElse(0);
//        int maxInt = Arrays.stream(arr).map(x -> x * x).max().orElse(0);
//        Arrays.stream(arr).map(x -> x * x).forEach(System.out::println);
//        System.out.println(minInt + ", " + maxInt);


        // 5
        List<Product> products1 = new ArrayList<>();
        products1.add(new Product(1, "Капуста", 100));
        products1.add(new Product(2, "Арбуз", 150));
        products1.add(new Product(3, "Топтыжка", 1987));
        List<Product> products2 = new ArrayList<>();
        products2.add(new Product(4, "Дыня", 50));
        products2.add(new Product(5, "Гречка", 250));
        products2.add(new Product(6, "Сникерс", 56));
        List<Product> products3 = new ArrayList<>();
        products3.add(new Product(7, "Цветок", 1000));
        products3.add(new Product(8, "Жвачка", 10));
        products3.add(new Product(9, "Тряпка", 50));
        List<Product> products4 = new ArrayList<>();
        products4.add(new Product(10, "Салат", 90));
        products4.add(new Product(11, "Кофе", 200));
        products4.add(new Product(12, "Лампочка", 190));
        List<Order> orders = new ArrayList<>();

        orders.add(new Order(1, 1, products1));
        orders.add(new Order(2, 2, products2));
        orders.add(new Order(3, 3, products3));
        orders.add(new Order(4, 4, products4));

        Map<Integer, Integer> customerTotalAmountMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerId,
                        Collectors.summingInt(order -> order.getProducts().stream()
                                .mapToInt(product -> product.getPrice()).sum())));
        customerTotalAmountMap.forEach((customerId, totalAmount) -> System.out.println(customerId + " " + totalAmount));

    }
}