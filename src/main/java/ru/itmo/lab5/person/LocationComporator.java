package ru.itmo.lab5.person;

import java.util.Comparator;

public class LocationComporator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
        if (p1.getLocation().getX() < p2.getLocation().getX())
            return -1;
        else if (p1.getLocation().getX() > p2.getLocation().getX())
            return 1;
        return 0;
    }
}