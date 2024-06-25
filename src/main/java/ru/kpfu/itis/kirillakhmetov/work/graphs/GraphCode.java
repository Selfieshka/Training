package ru.kpfu.itis.kirillakhmetov.work.graphs;

import java.util.LinkedList;

public class GraphCode {
    private MyLinkedList<Rebro> rebrs;
    private int n;

    public GraphCode(int[][] arr) {
        this.rebrs = new MyLinkedList<>();
        this.n = arr.length;
        decode(arr);
    }

    public boolean insert(int i, int j) {
        for (int k = 0; k < rebrs.size(); k++) {
            Rebro rebro = rebrs.get(k);
            if (((rebro.getI() == i && rebro.getJ() == j) ||
                    (rebro.getI() == j && rebro.getJ() == i))) {
                return false;
            }
        }
        rebrs.add(new Rebro(i, j));
        return true;
    }

    public boolean delete(int i, int j) {
        for (int k = 0; k < rebrs.size(); k++) {
            Rebro rebro = rebrs.get(k);
            if (((rebro.getI() == i && rebro.getJ() == j) ||
                    (rebro.getI() == j && rebro.getJ() == i))) {
                rebrs.remove(k);
                return true;
            }
        }
        return false;
    }

    public MyLinkedList<Rebro> incident(int i) {
        MyLinkedList<Rebro> incident = new MyLinkedList<>();
        for (int k = 0; k < rebrs.size(); k++) {
            Rebro rebro = rebrs.get(k);
            if (((rebro.getI() == i) || (rebro.getJ() == i))) {
                incident.add(rebro);
            }
        }

        return incident;
    }

    private void decode(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[i][j] != 0) {
                    rebrs.add(new Rebro(i, j));
                }
            }
        }
    }

    public int[][] jetMJ() {
        int[][] arr = new int[n][n];
        for (int k = 0; k < rebrs.size(); k++) {
            Rebro rebro = rebrs.get(k);
            arr[rebro.getI()][rebro.getJ()] = 1;
            arr[rebro.getJ()][rebro.getI()] = 1;
        }
        return arr;
    }

    public void modify(int i) {
        for (int k = 0; k < rebrs.size(); k++) {
            Rebro rebro = rebrs.get(k);
            if (((rebro.getI() == i) || (rebro.getJ() == i))) {
                rebrs.remove(k);
                k--;
            }
        }
    }

    public void printed() {
        rebrs.printed();
    }
}
