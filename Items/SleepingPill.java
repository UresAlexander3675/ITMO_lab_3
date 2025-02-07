package Items;

public class SleepingPill {
    private final double EFFECT_DURATION = 2.4;
    private boolean used = false;

    public void isUsed(){
        used = true;
    }

    public double getEffectDuration(){
        return EFFECT_DURATION;
    }

    @Override
    public String toString(){
        if (used){
            return "Банка снотворного (эффект: " + EFFECT_DURATION + ", использована)";
        } else {
            return "Банка снотворного (эффект: " + EFFECT_DURATION + ", не использована)";
        }
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
