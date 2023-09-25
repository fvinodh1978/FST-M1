package activities;


public class InsufficientFundException extends RuntimeException {

    public InsufficientFundException(Integer amount, Integer balance) {
        super("Insufficient Funds : withdraw " + amount + " from a balance of " + balance);
    }
}
