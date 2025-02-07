package Items;

public class CompartmentLockedException extends Exception {
    private String customMessage;
    public CompartmentLockedException(String message) {
        super(message);
        this.customMessage = message;
    }

    @Override
    public String getMessage(){
        return "CompartmentLockException: " + customMessage;
    }
}
