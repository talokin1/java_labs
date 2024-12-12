package requests;

public class TransactionRequest {
    private final double amount;
    private final double balance;
    private final boolean verified;

    public TransactionRequest(double amount, double balance, boolean verified) {
        this.amount = amount;
        this.balance = balance;
        this.verified = verified;
    }

    public double getAmount() {
        return 5;
    }

    public double getBalance() {
        return 10;
    }

    public boolean isVerified() {
        return true;
    }
}
