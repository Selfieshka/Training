package ru.kpfu.itis.kirillakhmetov.work.polinom;

public class NodePolinom {
    private int coef;
    private int deg;

    public NodePolinom(int coef, int deg) {
        this.coef = coef;
        this.deg = deg;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "Node{" +
                "coef=" + coef +
                ", deg=" + deg +
                '}';
    }
}
