package ru.itmo.lab5.person;

import ru.itmo.lab5.exceptions.IdException;
import sun.awt.image.ImageWatched;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Person {
    private static Integer uniqueID=1;
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double height; //Поле не может быть null, Значение поля должно быть больше 0
    private ColorE eyeColor; //Поле не может быть null
    private ColorH hairColor; //Поле не может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле может быть null
    private static LinkedList<Integer> idArray = new LinkedList<Integer>();



    public Person(int id, String name, Integer coordinatesX, Integer coordinatesY, Date date, Double height, ColorE eyeColor, ColorH hairColor, Country nationality, Integer locationX, Double locationY, Long locationZ, String locationName ){
        if (idArray.isEmpty()){
           idArray.add(id);
        } else {
            for (int i = 0; i<idArray.size(); i++){
                if(idArray.get(i).equals(id)){
                    throw new IdException("Человек с таким id уже есть в файле.");
                }
            } idArray.add(id);
        }
        if (id<=0){throw new IdException("Id должен быть больше 0");}
       this.id  = id;
       if (id >= uniqueID){uniqueID=id+1;}
       this.name=name;
       this.coordinates=new Coordinates(coordinatesX,coordinatesY);
       this.creationDate= date;
       this.height=height;
       this.eyeColor=eyeColor;
       this.hairColor=hairColor;
       this.nationality=nationality;
       this.location=new Location(locationX,locationY,locationZ,locationName);
    }

    public Person(String name,Integer coordinatesX,Integer coordinatesY, Double height, ColorE eyeColor, ColorH hairColor, Country nationality, Integer locationX, Double locationY, Long locationZ, String locationName){
        this.id  = uniqueID;
        idArray.add(id);
        uniqueID++;
        this.name=name;
        this.coordinates=new Coordinates(coordinatesX,coordinatesY);
        this.creationDate=new Date(System.currentTimeMillis());
        this.height=height;
        this.eyeColor=eyeColor;
        this.hairColor=hairColor;
        this.nationality=nationality;
        this.location=new Location(locationX,locationY,locationZ,locationName);
    }
    public int getID(){return id;}
    @Override
    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                id, name, coordinates, new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(creationDate), height, eyeColor, hairColor, nationality, location);
    }
    public String getName(){return name;}
    public Coordinates getCoordinates(){return coordinates;}
    public Double getHeight(){return height;}
    public ColorE getEyeColor(){return eyeColor;}
    public ColorH getHairColor(){return hairColor;}
    public Country getNationality(){return nationality;}
    public Location getLocation(){return location;}

    public void setName(String name){ this.name=name;}
    public void setCoordinates(Coordinates coordinates){this.coordinates= coordinates;}
    public void setHeight(Double height){this.height= height;}
    public void setEyeColor(ColorE eyeColor){this.eyeColor= eyeColor;}
    public void setHairColor(ColorH hairColor){this.hairColor= hairColor;}
    public void setNationality(Country nationality){this.nationality= nationality;}
    public void setLocation(Location location){this.location= location;}

    public LinkedList<String> getPersonFields(){
        LinkedList<String> fields= new LinkedList<>();
        fields.add(String.valueOf(id));
        fields.add(name);
        fields.add(String.valueOf(coordinates.getX()));
        fields.add(String.valueOf(coordinates.getY()));
        fields.add(new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(creationDate));
        fields.add(String.valueOf(height));
        fields.add(eyeColor.name());
        fields.add(hairColor.name());
        fields.add(nationality.name());
        fields.add(String.valueOf(location.getX()));
        fields.add(String.valueOf(location.getY()));
        fields.add(String.valueOf(location.getZ()));
        fields.add(location.getName());
        return fields;
    }

    public static LinkedList<Integer> getIdArray(){
        return idArray;
    }

    }


