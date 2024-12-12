package transactions;

import payment.PaymentSystem;

public abstract class Transaction {
    protected PaymentSystem paymentSystem;

    public Transaction(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public abstract String process(double amount);
}