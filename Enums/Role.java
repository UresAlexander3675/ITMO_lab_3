package Enums;

public enum Role {
    VICTIM("Жертва"),
    PASSENGER("Пассажир"),
    KILLER("Убийца"),
    DETECTIVE("Детектив"),
    DOCTOR("Доктор"),
    CONDUCTOR("Проводник");
    private final String text;
    Role(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
