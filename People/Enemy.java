package People;

import Enums.*;
import Items.*;
import Trains.*;
import java.util.Arrays;
import java.util.Random;

public class Enemy extends Person{
    private Health stateHealth;
    private Person disguise;
    private Knife knife;
    private boolean hasTrainKey;
    private int x, y;

    public Enemy(Role role, int health, Person disguise, Knife knife){
        super(role, health);
        System.out.println("Враг замаскировался под " + disguise);
        this.disguise = disguise;
        this.knife = knife;
        hasTrainKey = false;
        stateHealth = Health.HEALTHY;
    }

    public Enemy(Role role, int health, Knife knife){
        super(role, health);
        this.knife = knife;
        hasTrainKey = false;
        stateHealth = Health.HEALTHY;
    }

    public String getStateHealth(){
        return stateHealth + ", xp: " + getHealth();
    }

    public void breakIn(Compartment compartment) throws CompartmentLockedException{
        if(!compartment.isLocked()){
            this.x = compartment.getX();
            this.y = compartment.getY();
            System.out.println(this.toString() + " пробрался в " + compartment);
        } else {
            throw new CompartmentLockedException("This Compartment is locked!");
        }
    }

    public Person getDisguise(){
        return disguise;
    }

    @Override
    public void isHealthy(){
        if(getHealth() >= 15.0){
            stateHealth = Health.HEALTHY;
            System.out.printf(getRole() + " жив %.1f ", getHealth());
            System.out.println();
        } else if(getHealth() > 0){
            stateHealth = Health.SERIOUS_CONDITION;
            System.out.printf(getRole() + " в тяжелом состоянии %.1f ", getHealth());
            System.out.println();
        } else {
            stateHealth = Health.DIED;
            System.out.printf(getRole() + " умер %.1f ", getHealth());
            System.out.println();
        }
    }

    public void attack(Person people){
        people.setHealth(people.getHealth() - knife.damage());
        people.isHealthy();
    }

    public void sneakIntoTrain(Train train) throws CompartmentLockedException {
        if(train.getTrainStatus() == TrainStatus.STOPPED && hasTrainKey){
            System.out.println(getRole() + " пробрался в поезд без взлома");
        } else if(train.getTrainStatus() == TrainStatus.STOPPED && !hasTrainKey){
            this.forceBreakIn(train);
            System.out.println(getRole() + " пробрался в поезд co взломом");
        }
        else {
            System.out.println(getRole() + " не смог пробраться в поезд");
        }
    }

    public void escape(Compartment compartmentRatchett, Compartment escapeCompartment){
        this.x = compartmentRatchett.getX();
        this.y = compartmentRatchett.getY();
        for(int i = x; i < escapeCompartment.getX(); i++){
            x++;
            System.out.println("Враг идет по координатам: " + getCoordinates());
        }
        System.out.println("Враг ушел из купе через дверь, ведущую в купе " + escapeCompartment.getPersons());
    }

    public void hasTrainKey() {
        hasTrainKey = true;
    }

    public void forceBreakIn(Train train) throws CompartmentLockedException {
        if (hasTrainKey) {
            System.out.println(getRole() + " спокойно вошел, так как уже открыто.");
        }
        System.out.println(getRole() + " пытается взломать дверь...");
        Random random = new Random();
        if (random.nextBoolean()) { // 50% шанс успеха
            train.isBrokenTrainDoor();
            System.out.println(getRole() + " успешно взломал!");
        } else {
            throw new CompartmentLockedException(getRole() + " не смог взломать!");
        }
    }

    public void forceBreakIn(Compartment compartment) throws CompartmentLockedException {
        if (!compartment.isLocked()) {
            System.out.println(getRole() + " спокойно вошел в купе " + compartment.getNumber() + ", так как уже открыто.");
        }
        System.out.println(getRole() + " пытается взломать дверь...");
        Random random = new Random();
        if (random.nextBoolean()) {
            compartment.isBroken();
            System.out.println(getRole() + " успешно взломал купе " + compartment.getNumber());
        } else {
            throw new CompartmentLockedException(getRole() + " не смог взломать купе " + compartment.getNumber());
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCoordinates(){
        int[] coordinates = {x, y};
        return Arrays.toString(coordinates);
    }

    @Override
    public String toString(){
        return "Враг (здоровье: " + getHealth() + ", роль в повествовании: " + getRole() + ", маскировка под: " + disguise + ", нож: " + knife + ")";
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
