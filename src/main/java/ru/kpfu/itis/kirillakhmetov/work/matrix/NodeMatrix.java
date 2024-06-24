package ru.kpfu.itis.kirillakhmetov.work.matrix;

public class NodeMatrix {
    private int i;
    private int j;
    private int value;

    public NodeMatrix(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value + " ";
    }
}
