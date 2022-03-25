package ru.itmo.lab5.person;

import java.util.Comparator;

public class PersonComporator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
        if (p1.getHeight() < p2.getHeight())
            return -1;
        else if (p1.getID() > p2.getID())
            return 1;
        return 0;
    }
}
