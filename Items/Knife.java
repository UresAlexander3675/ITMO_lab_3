package Items;

public record Knife(int damage) {

    public int getDamage(){
        return damage;
    }

    public Knife afterAttack(){
        return new Knife(damage);
    }

    @Override
    public String toString(){
        return "Нож (поражение: " + damage;
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
