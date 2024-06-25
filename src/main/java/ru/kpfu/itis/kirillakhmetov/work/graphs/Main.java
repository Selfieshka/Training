package ru.kpfu.itis.kirillakhmetov.work.graphs;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1
        int[][] matrix = {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}};

        GraphCode graphCode = new GraphCode(matrix);
        System.out.println(Arrays.deepToString(graphCode.jetMJ()));
        System.out.println(graphCode.insert(3,2));
        System.out.println(graphCode.delete(1,0));
        System.out.println(graphCode.incident(0));
        graphCode.modify(0);
        graphCode.printed();


//         2
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("result"), StandardCharsets.UTF_8))) {
            Set<String> words1 = readFile("file1");
            Set<String> words2 = readFile("file2");
            Set<String> words = new HashSet<>();
            words.addAll(words1);
            words.addAll(words2);
            List<String> sortedWords = words.stream().sorted().toList();

            for (String word : sortedWords) {
                bw.write(word + "\n");
            }
            System.out.println(words);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Set<String> readFile(String filename) {
        Set<String> words = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
            words = new HashSet<>();
            String line;
            while ((line = br.readLine()) != null) {
                words.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }
}