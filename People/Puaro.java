package People;

import Enums.*;
import Items.*;
import Trains.*;
import java.util.*;

public class Puaro extends Person implements Investigator{
    private Health stateHealth;
    public Puaro(Role role, int health){
        super(role, health);
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

    @Override
    public void investigate(ArrayList<ClueType> clues){
        HashMap<ClueType, Boolean> checkClues = new HashMap<>();
        for (ClueType clue: clues){
            checkClues.put(clue, false);
        }
        for(Map.Entry<ClueType, Boolean> entry : checkClues.entrySet()){
            ClueType a = entry.getKey();
            Boolean b = entry.getValue();
            checkClues.replace(a, b, true);
            System.out.println(getRole() + " Пуаро исследует улику: " + a);
        }
    }

    public void presentFirstVersion(){
        System.out.println("Представляю первую версию...");

        PocketWatch pocketWatch = new PocketWatch(1.40);
        Ratchett ratchett = new Ratchett(Role.VICTIM, 100, pocketWatch);
        Conductor conductor = new Conductor(Role.CONDUCTOR, 90, 10, 12);
        DoctorConstantine constantine = new DoctorConstantine(Role.DOCTOR, 86);
        MrHardman hardman = new MrHardman(Role.DETECTIVE, 56, "New York agency", 13, 12);
        Knife knife1 = new Knife(34);
        Enemy enemy = new Enemy(Role.KILLER, 96, knife1);
        Random random = new Random();

        Train train = new Train(TrainStatus.MOVING);
        Carriage carriage1 = new Carriage(Destination.ISTAMBUL, Destination.KALE);
        train.addCarriage(carriage1);
        Compartment compartment2 = new Compartment(16, 15, 4);
        Compartment compartment3 = new Compartment(17, 17, 4);
        Compartment compartment4 = new Compartment(20, 20, 4);
        carriage1.addCompartment(compartment2);
        carriage1.addCompartment(compartment3);
        carriage1.addCompartment(compartment4);
        compartment2.addPerson(ratchett);
        compartment3.addPerson(constantine);
        compartment4.addPerson(hardman);

        conductor.speak(ratchett, 00.37);
        System.out.println(ratchett.getStateHealth());

        pocketWatch.broke();
        System.out.println("Время остановилось на: " + pocketWatch.getTime());

        train.enterSnowDrift(0.30);
        ratchett.tryToLeaveTrain(train);
        conductor.tryToLeaveTrain(train);
        constantine.tryToLeaveTrain(train);

        while(ratchett.getHealth() > 0){
            enemy.attack(ratchett);
        }

        constantine.examineBody(ratchett);
        constantine.setTimeOfDeath(random.nextDouble(0.0, 2.0 + 1), ratchett);

        hardman.observeCorridor(train.getCarriages().getFirst());

        System.out.println(enemy.getRole() + " среди пассажиров вагона: " + carriage1.getCarriageDestination());
    }

    public void presentSecondVersion() throws CompartmentLockedException {
        System.out.println("Представляю вторую версию...");
        Ratchett ratchett = new Ratchett(Role.VICTIM, 100);
        Conductor conductor = new Conductor(Role.CONDUCTOR, 90, 10, 12);
        MrHardman hardman = new MrHardman(Role.DETECTIVE, 56, "New York agency", 13, 12);
        Knife knife1 = new Knife(15);
        Enemy enemy = new Enemy(Role.KILLER, 96, conductor, knife1);


        Train train = new Train(TrainStatus.MOVING);
        Carriage carriage1 = new Carriage(Destination.ISTAMBUL, Destination.KALE);
        train.addCarriage(carriage1);
        Compartment ratchettCompartment = new Compartment(16, 15, 4);
        Compartment habbardCompartment = new Compartment(20, 20, 4);
        carriage1.addCompartment(ratchettCompartment);
        carriage1.addCompartment(new Compartment(17, 17, 4));
        carriage1.addCompartment(habbardCompartment);
        habbardCompartment.addPerson(new MrsHabbard(Role.PASSENGER, 90));
        ratchettCompartment.addPerson(ratchett);
        PocketWatch pocketWatch = new PocketWatch(1.40);

        ratchett.warnHardman(hardman, "описал: " + enemy, "убийство произойдет в поезде " + carriage1 + " в " + pocketWatch.getTime());
        ratchett.takeSleepingPill();
        ratchett.isSleeping();

        train.setTrainStatus(TrainStatus.STOPPED);
        enemy.hasTrainKey();
        enemy.sneakIntoTrain(train);

        if(ratchettCompartment.isLocked()){
            enemy.breakIn(ratchettCompartment);
        } else {
            enemy.forceBreakIn(ratchettCompartment);
        }

        try{
            Compartment lastCompartment = carriage1.getCompartments().get(1);
            enemy.forceBreakIn(lastCompartment);
        } catch (CompartmentLockedException e){
            System.out.println(e.getMessage());
        } finally {
            for (int i = 1; i <= 13; i++){
                enemy.attack(ratchett);
            }
            enemy.escape(ratchettCompartment, habbardCompartment);
        }
    }

    public String introduce(Person person){
        return "Мы собрались здесь, чтобы расследовать убийство " + person;
    }

    @Override
    public String toString(){
        return "Детектив Пуаро (здоровье: " + getHealth() + ", роль в повествовании: " + getRole() + ")";
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
