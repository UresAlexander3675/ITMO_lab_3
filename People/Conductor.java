package People;
import java.util.*;
import Enums.*;
import Trains.*;

public class Conductor extends Person{
    private Health stateHealth;
    private ArrayList<String> doorOpenAtStations;
    private int x, y;

    public Conductor(Role role, double health, int x, int y){
        super(role, health);
        this.x = x;
        this.y = y;
        stateHealth = Health.HEALTHY;
    }

    public String getStateHealth(){
        return stateHealth + ", xp: " + getHealth();
    }

    @Override
    public void isHealthy(){
        if(getHealth() >= 5.0){
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

    public void openCompartment(Compartment compartment){
        while(x != compartment.getX()){
            x++;
        }
        while(y != compartment.getY()){
            y++;
        }
        compartment.open();
        System.out.println(getRole() + " открыл дверь");
    }

    public void closeCompartment(Compartment compartment){
        while(x != compartment.getX()){
            x++;
        }
        while(y != compartment.getY()){
            y++;
        }
        compartment.lock();
        System.out.println(getRole() + " закрыл дверь");
    }

    public void speak(Ratchett ratchett, double time){
        System.out.println(getRole() + " разговаривал с " + ratchett);
        ratchett.getPocketWatch().setTime(time);
        System.out.println(ratchett.getPocketWatch());

    }

    @Override
    public String toString(){
        return "Проводник поезда (здоровье: " + getStateHealth() + ", роль в повествовании: " + getRole() + ")";
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
