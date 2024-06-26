package ru.kpfu.itis.kirillakhmetov.work.polinom;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1

//        MyPolinom polinom = new MyPolinom("polinom");
//        polinom.mult(new MyPolinom("polinom2"));
//        System.out.println(polinom.value(5));
//        polinom.derivate2();
//        polinom.printed();

        // 2

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("text"), StandardCharsets.UTF_8))) {
            List<String> lines = new ArrayList<>();
            String line1;
            while((line1 = br.readLine()) != null) {
                lines.add(line1);
            }

            List<String> words = getStrings(lines);
            words.stream().filter(word -> ('A' <= word.charAt(0) && word.charAt(0) <= 'Z' ||
                    word.charAt(0) == 'i' && word.charAt(1) == 't')).collect(Collectors.groupingBy(
                            s -> ('A' <= s.charAt(0) && s.charAt(0) <= 'Z') ?
                            "Начинается с заглавной" : (s.charAt(0) == 'i' && s.charAt(1) == 't') ?
                            "Начинается с it" : null,
                            Collectors.counting()
            )).forEach((name, count) -> System.out.println(name + ": " + count));

            words.stream().filter(word -> ('A' <= word.charAt(0) && word.charAt(0) <= 'Z' ||
                    word.charAt(0) == 'i' && word.charAt(1) == 't')).collect(Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()
            )).forEach((name, count) -> System.out.println(name + ": " + count));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getStrings(List<String> lines) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch != ' ' && ch != '.' && ch != ',' && !('0' <= ch && ch <= '9')) {
                    sb.append(ch);
                    if ((i == (line.length() - 1)) && !sb.isEmpty()) {
                        words.add(sb.toString());
                        sb = new StringBuilder();
                    }
                } else if ((ch == ' ') && !sb.isEmpty()) {
                    words.add(sb.toString());
                    sb = new StringBuilder();
                } else if (!sb.isEmpty()) {
                    sb = new StringBuilder();
                }
            }
        }

        return words;
    }
}