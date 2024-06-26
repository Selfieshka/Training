package ru.kpfu.itis.kirillakhmetov.work;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("numsAgain.txt"))) {
            int b = 0;
            int i = 0;
            List<Integer> list = new ArrayList<>();

            while ((b = bufferedInputStream.read()) != -1) {
                if ((char) b != ' ') {
                    System.out.println((char) b);
                    b = b - '0';
                    if (i == 0) {
                        i = b;
                    } else {
                        i = i * 10 + b;
                    }
                } else {
                    list.add(i);
                    i = 0;
                }
            }
            if (i != 0) {
                list.add(i);
            }
            System.out.println(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}