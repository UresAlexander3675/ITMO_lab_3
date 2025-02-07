package People;

import Enums.Health;
import Enums.Role;
import Items.*;

public class Ratchett extends Person{
    private Health stateHealth;
    private boolean isSleeping;
    private PocketWatch pocketWatch;


    public Ratchett(Role role, double health, PocketWatch pocketWatch) {
        super(role, health);
        isSleeping = false;
        this.pocketWatch = pocketWatch;
        stateHealth = Health.HEALTHY;
    }

    public Ratchett(Role role, double health) {
        super(role, health);
        isSleeping = false;
        stateHealth = Health.HEALTHY;
    }

    public void takeSleepingPill(){
        isSleeping = true;
        SleepingPill sleepingPill = new SleepingPill();
        double health1 = this.getHealth();
        health1 -= sleepingPill.getEffectDuration();
        setHealth(health1);
    }

    public void warnHardman(MrHardman hardman, String describition, String message){
        hardman.recordEnemy(describition);
        hardman.setMessage(message);
    }

    public String getStateHealth(){
        return stateHealth + ", xp: " + getHealth();
    }

    public PocketWatch getPocketWatch(){
        return pocketWatch;
    }

    @Override
    public void isHealthy(){
        if(getHealth() >= 17.0){
            stateHealth = Health.HEALTHY;
            System.out.printf(getRole() + " жив %.1f ", getHealth());
            System.out.println();
        } else if(getHealth() > 0){
            stateHealth = Health.SERIOUS_CONDITION;
            System.out.printf(getRole() + " в тяжелом состоянии %.1f ", getHealth());
            System.out.println();
        } else if(getHealth() <= 0){
            stateHealth = Health.DIED;
            System.out.printf(getRole() + " умер %.1f ", getHealth());
            System.out.println();
        }
    }

    public boolean isSleeping(){
        if(isSleeping){
            System.out.println("Рэтчетт спит");
            return true;
        } else {
            System.out.println("Рэтчетт не спит");
            return false;
        }
    }

    @Override
    public String toString(){
        return "Рэтчетт (роль в повествовании: " + getRole() + ", " + getStateHealth() + ")";
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
