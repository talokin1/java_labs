package requests;

public class TransactionRequest {
    private double amount;
    private double balance;
    private boolean verified;


    public TransactionRequest(double amount, double balance, boolean verified) {
        this.amount = amount;
        this.balance = balance;
        this.verified = verified;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {

        return balance;
    }

    public boolean isVerified() {

        return verified;
    }
}
