package Trains;
import java.util.*;
import Enums.*;

public class Train {
    private ArrayList<Carriage> carriages = new ArrayList<>();
    private TrainStatus trainStatus;
    private double timeOfDrift;
    private boolean isBrokenTrainDoor = false;

    public Train(TrainStatus trainStatus){
        this.trainStatus = trainStatus;
    }

    public void addCarriage(Carriage carriage){
        carriages.add(carriage);
    }

    public ArrayList<Carriage> getCarriages(){
        return carriages;
    }

    public TrainStatus getTrainStatus(){
        return trainStatus;
    }

    public void setTrainStatus(TrainStatus trainStatus){
        this.trainStatus = trainStatus;
    }

    public void enterSnowDrift(double time){
        trainStatus = TrainStatus.SNOW_DRIFT;
        this.timeOfDrift = time;
        System.out.println("В " + time + ", поезд вошел в " + trainStatus);
    }

    public void brokeTrainDoor(){
        isBrokenTrainDoor = true;
    }

    public boolean isBrokenTrainDoor(){
        return isBrokenTrainDoor;
    }

    @Override
    public String toString(){
        return "Поезд (вагоны: " + carriages + ", статус: " + trainStatus;
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
