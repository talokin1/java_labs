package transactions;

import payment.PaymentSystem;

public class BankTransferTransaction extends Transaction {
    public BankTransferTransaction(PaymentSystem paymentSystem) {
        super(paymentSystem);
    }

    @Override
    public String process(double amount) {
        return paymentSystem.processPayment(amount) + "\nProcessing bank transfer...";
    }
}