package People;
import Enums.*;

import java.util.Random;

public class DoctorConstantine extends Person {
    private Health stateHealth;

    DoctorConstantine(Role role, int health) {
        super(role, health);
        stateHealth = Health.HEALTHY;
    }

    public String getStateHealth(){
        return stateHealth + ", xp: " + getHealth();
    }

    public void examineBody(Person person){
        PartsOfBody[] partsOfBodies1 = person.getPartsOfBodies();
        Random randomizer = new Random();
        PartsOfBody random = partsOfBodies1[randomizer.nextInt(0, partsOfBodies1.length)];
        for(PartsOfBody parts: partsOfBodies1){
            System.out.println(getRole() + " обследует " + parts);
        }

        System.out.println("У " + person.getRole() + " повреждено " + random);
    }

    @Override
    public void isHealthy(){
        if(getHealth() >= 12.0){
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

    public void setTimeOfDeath(double timeOfDeath, Person person){
        System.out.println(getRole() + " установил время смерти " + timeOfDeath + " для " + person);
        person.setTimeOfDeath(timeOfDeath);
    }

    @Override
    public String toString(){
        return "Доктор Константин (здоровье: " + getHealth() + ", роль в повествовании: " + getRole() + ")";
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
