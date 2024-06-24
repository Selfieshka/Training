package ru.kpfu.itis.kirillakhmetov.work.history;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
//    static int count = 0;
//    public static void main(String[] args) throws IOException {
//        BufferedReader brPerson = new BufferedReader(new InputStreamReader(new FileInputStream("persons"), StandardCharsets.UTF_8));
//        BufferedReader brEvent = new BufferedReader(new InputStreamReader(new FileInputStream("events"), StandardCharsets.UTF_8));
//
//        List<Person> persons = new ArrayList<>();
//        List<Event> events = new ArrayList<>();
//
//        String line;
//        String[] splitLine;
//        Person person;
//        Event event;
//
//        while ((line = brPerson.readLine()) != null) {
//            splitLine = line.split(", ");
//            person = new Person(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]));
//            persons.add(person);
//        }
//        while ((line = brEvent.readLine()) != null) {
//            splitLine = line.split(", ");
//            event = new Event(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]));
//            events.add(event);
//        }
//
//        persons.stream().collect(Collectors.groupingBy(
//                        Person::getCountry,
//                        Collectors.counting()
//                )
//        ).forEach((name, count) -> System.out.println(name + ": " + count));
//
//        String country = "США";
//        List<Person> personInCountry = persons.stream().filter(pr -> pr.getCountry().equals(country)).toList();
//
//        Long result = events.stream().filter(event1 -> personInCountry.stream()
//                        .anyMatch(item -> item.getName().equals(event1.getNamePerson()) &&
//                                (item.getYear2() - event1.getYear1()) <= (event1.getYear1() - item.getYear1())))
//                .count();
//        System.out.println(result);
//
//        //
//        int n = 5;
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("nums"), StandardCharsets.UTF_8));
//        List<Integer> nums = new ArrayList<>();
//        String line;
//        while ((line = br.readLine()) != null) {
//            nums.add(Integer.parseInt(line));
//        }
//
//        for (int i = 0; i < n; i++) {
//            Thread runnable = new Thread(() -> {
//                try (OutputStreamWriter file = new OutputStreamWriter(new FileOutputStream("test" + count++ + ".bin"))) {
//                    for (Integer num : nums) {
//                        file.write(num);
//                    }
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            runnable.start();
//        }
//    }
}