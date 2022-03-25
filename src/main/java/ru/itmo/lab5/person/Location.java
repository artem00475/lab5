package ru.itmo.lab5.person;

public class Location {
    private Integer x; //Поле не может быть null
    private Double y; //Поле не может быть null
    private Long z; //Поле не может быть null
    private String name; //Длина строки не должна быть больше 374, Поле не может быть null

    public Location(Integer x, Double y, Long z, String name){
        this.x=x;
        this.y=y;
        this.z=z;
        this.name=name;
    }
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", x, y, z, name);
    }

    public Integer getX(){return x;}
    public Double getY(){return y;}
    public Long getZ(){return z;}
    public String getName(){return name;}

    public boolean compare(Location location){
        if (x> location.getX()){
            return true;
        } else{
            return false;
        }
    }


}
