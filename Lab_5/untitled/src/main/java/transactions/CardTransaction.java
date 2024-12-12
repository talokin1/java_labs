package transactions;

import payment.PaymentSystem;

public class CardTransaction extends Transaction {
    public CardTransaction(PaymentSystem paymentSystem) {
        super(paymentSystem);
    }

    @Override
    public String process(double amount) {
        return paymentSystem.processPayment(amount) + "\nProcessing card payment...";
    }
}