package People;
import Enums.*;
import Items.PocketWatch;
import Trains.*;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Person {
    private Role role;
    private double health;
    private PartsOfBody[] partsOfBodies = {PartsOfBody.BODY, PartsOfBody.HEAD, PartsOfBody.LEFT_ARM, PartsOfBody.RIGHT_ARM, PartsOfBody.LEFT_LEG, PartsOfBody.RIGHT_LEG};

    Person(Role role, double health){
        this.role = role;
        this.health = health;
    }

    abstract void isHealthy();

    public Role getRole(){
        return role;
    }

    public void setTimeOfDeath(double time){
        PocketWatch pocketWatch1 = new PocketWatch(time);
    }

    public double getTimeOfDeath(PocketWatch pocketWatch){
        return pocketWatch.getTime();
    }

    public boolean tryToLeaveTrain(Train train){
        if(train.getTrainStatus() == TrainStatus.MOVING || train.getTrainStatus() == TrainStatus.SNOW_DRIFT){
            System.out.println(role + " не может покинуть поезд");
            return false;
        }
        System.out.println(role + " может покинуть поезд");
        return true;
    }

    public double getHealth(){
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void passBy(Compartment compartment){
        ArrayList<Person> personArrayList = compartment.getPersons();
        for(Person person: personArrayList){
            System.out.println(getRole() + " прошел мимо " + person);
        }
    }

    public PartsOfBody[] getPartsOfBodies(){
        return partsOfBodies;
    }
}
