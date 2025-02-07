package Trains;

import Enums.*;
import java.util.*;

public class Carriage {
    private ArrayList<Compartment> compartments = new ArrayList<>();
    private Map<Destination, Destination> fromToDestination;

    public Carriage(Destination fromDestination, Destination toDestination){
        fromToDestination = Map.of(fromDestination, toDestination);
    }

    public void addCompartment(Compartment compartment){
        compartments.add(compartment);
    }

    public ArrayList<Compartment> getCompartments(){
        return compartments;
    }

    public Map<Destination, Destination> getCarriageDestination(){
        return fromToDestination;
    }

    public void changeDestination(Destination destination1, Destination destination2){
        fromToDestination.replace(destination1, destination2);
    }

    public Compartment findCompartment(int x, Map<Integer, Compartment> map){
        for(Map.Entry<Integer, Compartment> entry: map.entrySet()){
            if(entry.getKey() == x){
                return entry.getValue();
            }
        }
        return map.get(x);
    }

    @Override
    public String toString(){
        return "Вагон: купе - " + compartments + ", направление: " + fromToDestination;
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