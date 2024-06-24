package ru.kpfu.itis.kirillakhmetov.work.history;

public class Person {
    private String name;
    private String country;
    private int year1;
    private int year2;

    public Person(String name, String country, int year1, int year2) {
        this.name = name;
        this.country = country;
        this.year1 = year1;
        this.year2 = year2;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getYear1() {
        return year1;
    }

    public int getYear2() {
        return year2;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", year1=" + year1 +
                ", year2=" + year2 +
                '}';
    }
}
