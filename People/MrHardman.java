package People;

import Enums.*;
import Trains.Carriage;
import Trains.Compartment;

import java.util.*;

public class MrHardman extends Person implements Investigator{
    private Health stateHealth;
    private String agency;
    private String messageFromRatchett;
    int x,y;

    public MrHardman(Role role, int health, String agency, int x, int y){
        super(role, health);
        this.agency = agency;
        this.x = x;
        this.y = y;
        stateHealth = Health.HEALTHY;
    }

    @Override
    public void isHealthy(){
        if(getHealth() >= 9.2){
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
        Random random = new Random();
        int end = random.nextInt(1, clues.size() + 1);
        int start = 1;
        for(Map.Entry<ClueType, Boolean> entry : checkClues.entrySet()){
            if(start > end){
                break;
            }
            ClueType a = entry.getKey();
            Boolean b = entry.getValue();
            checkClues.replace(a, b, true);
            System.out.println(getRole() + " Хардман исследует улику: " + a);
            start++;
        }
    }

    public void observeCorridor(Carriage carriage){
        ArrayList<Compartment> compartments = carriage.getCompartments();
        HashMap<Compartment, Boolean> checkCompartments = new HashMap<>();
        HashMap<Integer, Compartment> coordinatesX = new HashMap<>();

        for (Compartment compartment: compartments){
            coordinatesX.put(compartment.getX(), compartment);
            checkCompartments.put(compartment, false);
        }

        for(int i = x; i <= compartments.get(compartments.size() - 1).getX(); i++){
            x = i;
            System.out.println("Проходим по коридору - координаты " + getCoordinates());
            if(coordinatesX.containsKey(x)){
                Compartment compartment1 = carriage.findCompartment(x, coordinatesX);
                checkCompartments.replace(compartment1, false, true);
                System.out.println(compartment1 + " обследована");
            }
        }
    }

    public void recordEnemy(String description){
        System.out.println("Заметки Хардмана: " + description);
    }

    public String getMessage(){
        return messageFromRatchett;
    }

    public void setMessage(String message){
        this.messageFromRatchett = message;
    }

    public String getCoordinates(){
        int[] coordinates = {x, y};
        return Arrays.toString(coordinates);
    }

    public String getStateHealth(){
        return stateHealth + ", xp: " + getHealth();
    }

    @Override
    public String toString(){
        return "Мистер Хардман (здоровье: " + getHealth() + ", роль в повествовании: " + getRole() + ", агенство: " + agency + ")";
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
