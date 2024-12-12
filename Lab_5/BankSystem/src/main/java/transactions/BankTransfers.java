package transactions;

import payment.PaymentSystem;

public class BankTransfers extends Transaction {

    public BankTransfers(PaymentSystem paymentSystem) {
        super(paymentSystem);
    }

    @Override
    public String process(double amount) {
        return paymentSystem.processPayment(amount) + "\nProcessing bank transfer...";
    }
}
