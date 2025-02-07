package People;

import Enums.Health;
import Enums.Role;

public class MrsHabbard extends Person{
    private Health stateHealth;
    public MrsHabbard(Role role, int health){
        super(role, health);
        stateHealth = Health.HEALTHY;
    }

    @Override
    public void isHealthy(){
        if(getHealth() >= 12.0){
            stateHealth = Health.HEALTHY;
            System.out.printf(getRole() + " жива %.1f ", getHealth());
            System.out.println();
        } else if(getHealth() > 0){
            stateHealth = Health.SERIOUS_CONDITION;
            System.out.printf(getRole() + " в тяжелом состоянии %.1f ", getHealth());
            System.out.println();
        } else {
            stateHealth = Health.DIED;
            System.out.printf(getRole() + " умерла %.1f ", getHealth());
            System.out.println();
        }
    }

    public String getStateHealth(){
        return stateHealth + ", xp: " + getHealth();
    }

    @Override
    public String toString(){
        return "Миссис Хаббард (здоровье: " + getHealth() + ", роль в повествовании: " + getRole() + ")";
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
