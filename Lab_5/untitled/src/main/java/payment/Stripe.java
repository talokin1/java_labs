package payment;

public class Stripe implements PaymentSystem{
    @Override
    public String processPayment(double amount) {
        return  "Stripe processed of payment " + amount;
    }

}
