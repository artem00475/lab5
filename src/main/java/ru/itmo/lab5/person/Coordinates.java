package ru.itmo.lab5.person;

import ru.itmo.lab5.exceptions.CoordinatesException;

public class Coordinates {
    private Integer x; //Максимальное значение поля: 408, Поле не может быть null
    private Integer y; //Значение поля должно быть больше -876, Поле не может быть null

    public Coordinates(Integer x, Integer y){
        if (x>408){throw new CoordinatesException("Координата Х не должна превышать 408");}
        this.x=x;
        if (y<=-876){throw new CoordinatesException("Координата Y должна быть больше -876");}
        this.y=y;
    }
    @Override
    public String toString() {
        return String.format("%s,%s", x, y);
    }

    public Integer getX(){return x;}
    public Integer getY(){return y;}
}

