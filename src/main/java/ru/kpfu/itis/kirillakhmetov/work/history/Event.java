package ru.kpfu.itis.kirillakhmetov.work.history;

public class Event {
    private String nameEvent;
    private String namePerson;
    private int year1;
    private int year2;

    public Event(String nameEvent, String namePerson, int year1, int year2) {
        this.nameEvent = nameEvent;
        this.namePerson = namePerson;
        this.year1 = year1;
        this.year2 = year2;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public int getYear1() {
        return year1;
    }

    public int getYear2() {
        return year2;
    }

    @Override
    public String toString() {
        return "Event{" +
                "nameEvent='" + nameEvent + '\'' +
                ", namePerson='" + namePerson + '\'' +
                ", year1=" + year1 +
                ", year2=" + year2 +
                '}';
    }
}
