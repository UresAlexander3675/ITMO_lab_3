package Trains;

import People.*;
import java.util.*;

public class Compartment {
    private int number;
    private boolean isLocked;
    private ArrayList<Person> persons = new ArrayList<>();
    private boolean isBroken;
    int x, y;

    public Compartment(int number, int x, int y){
        this.number = number;
        isBroken = false;
        isLocked = true;
        this.x = x;
        this.y = y;
    }

    public void open(){
        isLocked = false;
    }

    public void lock(){
        isLocked = true;
    }

    public boolean isLocked(){
        Random random = new Random();
        return random.nextBoolean();
    }

    public boolean isBroken(){
        isLocked = false;
        return isBroken;
    }

    public int getNumber(){
        return number;
    }

    public ArrayList<Person> getPersons(){
        return persons;
    }

    public void addPerson(Person person){
        persons.add(person);
    }

    public void setBrokenStatus(boolean status){
        this.isBroken = status;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString(){
        return "Купе (номер: " + number + ", пассажиры: " + persons + ")";
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass();
    }
}