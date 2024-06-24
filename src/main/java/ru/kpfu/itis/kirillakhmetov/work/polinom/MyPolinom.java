package ru.kpfu.itis.kirillakhmetov.work.polinom;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MyPolinom {
    private MyDoubleLinkedList<NodePolinom> polinom;

    public MyPolinom(String filename) {
        polinom = new MyDoubleLinkedList<>();
        createPolinom(filename);
    }

    private void createPolinom(String filename) {
        try (BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
            String line;

            while ((line = bis.readLine()) != null) {
                String[] param = line.split(", ");
                polinom.add(new NodePolinom(Integer.parseInt(param[0]), Integer.parseInt(param[1])));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(int coef, int degree) {
        polinom.add(new NodePolinom(coef, degree));
    }

    public void delete(int deg) {
        for (int i = 0; i < polinom.size(); i++) {
            if (polinom.get(i).getDeg() == deg) {
                polinom.remove(i);
                return;
            }
        }
    }

    public void combine() {
        for (int i = 0; i < polinom.size(); i++) {
            NodePolinom nodePolinom1 = polinom.get(i);
            for (int j = i + 1; j < polinom.size() - 1; j++) {
                NodePolinom nodePolinom2 = polinom.get(j);
                if (nodePolinom1.getDeg() == nodePolinom2.getDeg()) {
                    nodePolinom2.setCoef(nodePolinom1.getCoef() + nodePolinom2.getCoef());
                    polinom.remove(j);
                }
            }
        }
    }

    public void mult(MyPolinom polinom1) {
        NodePolinom nodePolinom = polinom1.getPolinom().get(0);
        for (int i = 0; i < polinom.size(); i++) {
            NodePolinom nodePolinom2 = polinom.get(i);
            nodePolinom2.setCoef(nodePolinom2.getCoef() * nodePolinom.getCoef());
            nodePolinom2.setDeg(nodePolinom2.getDeg() + nodePolinom.getDeg());
        }
    }

    public void printed() {
        polinom.printed();
    }

    private MyDoubleLinkedList<NodePolinom> getPolinom() {
        return polinom;
    }

    public int value(int x) {
        int sum = 0;
        for (int i = 0; i < polinom.size(); i++) {
            NodePolinom nodePolinom = polinom.get(i);
            sum += (int) (Math.pow(x, nodePolinom.getDeg()) * nodePolinom.getCoef());
        }
        return sum;
    }

    public void derivate2() {
        for (int i = 0; i < polinom.size(); i++) {
            NodePolinom nodePolinom = polinom.get(i);
            if (nodePolinom.getDeg() == 0 || nodePolinom.getDeg() == 1) {
                polinom.remove(i);
                break;
            }
            nodePolinom.setCoef(nodePolinom.getCoef() * nodePolinom.getDeg() * (nodePolinom.getDeg() - 1));
            nodePolinom.setDeg(nodePolinom.getDeg() - 2);
        }
    }
}
