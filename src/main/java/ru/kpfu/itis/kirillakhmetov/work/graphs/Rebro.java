package ru.kpfu.itis.kirillakhmetov.work.graphs;

public class Rebro {
    private int i;
    private int j;

    public Rebro(int a, int b) {
        this.i = a;
        this.j = b;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public String toString() {
        return "Rebro{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}

