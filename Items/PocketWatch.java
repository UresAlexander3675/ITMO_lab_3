package Items;

public class PocketWatch {
    private double time;
    private double integrity = 20.0;

    public PocketWatch(double time){
        this.time = time;

    }

    public double getIntegrity(){
        return integrity;
    }

    public double getTime(){
        return time;
    }

    public void setTime(double time){
        this.time = time;
    }

    public void broke(){
        while (integrity >= 16.7){
            integrity -= 5.2;
        }
        System.out.println("Часы сломаны: теперь их прочноcть - " + integrity + " (" + this.toString() + ")");
    }

    @Override
    public String toString(){
        return "Наручные часы (время: " + time + ", прочность: " + integrity + "/20.0)";
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
