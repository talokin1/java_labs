package payment;

public class PayPal implements PaymentSystem{
    @Override
    public String processPayment(double amount) {
        return "PayPal processed of payment " + amount;
    }

}