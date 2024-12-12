package payment;

public class AmazonPay implements PaymentSystem{
    @Override
    public String processPayment(double amount) {
        return "AmazonPay processed of payment  " + amount;
    }
}

