package payment;

public class CreditCard implements PaymentSystem{
    @Override
    public String processPayment(double amount) {
        return "CreditCard processed of payment " + amount;
    }
}
