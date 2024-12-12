package payment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

public class PaymentSystemTest {

    @Test
    public void testAmazonPayProcessing() {
        PaymentSystem paymentSystem = new AmazonPay();
        String result = paymentSystem.processPayment(5000);
        assertNotNull(result, "AmazonPay should return a result for payment processing");
    }

    @Test
    public void testCreditCardProcessing() {
        PaymentSystem paymentSystem = new CreditCard();
        String result = paymentSystem.processPayment(10000);
        assertNotNull(result, "CreditCard should return a result for payment processing");
    }

    @Test
    public void testPayPalProcessing() {
        PaymentSystem paymentSystem = new PayPal();
        String result = paymentSystem.processPayment(1500);
        assertNotNull(result, "PayPal should return a result for payment processing");
    }

    @Test
    public void testStripeProcessing() {
        PaymentSystem paymentSystem = new Stripe();
        String result = paymentSystem.processPayment(7500);
        assertNotNull(result, "Stripe should return a result for payment processing");
    }

    @ParameterizedTest
    @CsvSource({
            "AmazonPay, 5000, true",
            "CreditCard, 10000, true",
            "PayPal, 1500, true",
            "Stripe, 7500, true"
    })
    public void testPaymentSystemProcessing(String systemType, double amount, boolean expected) {
        PaymentSystem paymentSystem;
        switch (systemType) {
            case "AmazonPay":
                paymentSystem = new AmazonPay();
                break;
            case "CreditCard":
                paymentSystem = new CreditCard();
                break;
            case "PayPal":
                paymentSystem = new PayPal();
                break;
            case "Stripe":
                paymentSystem = new Stripe();
                break;
            default:
                throw new IllegalArgumentException("Unknown payment system: " + systemType);
        }

        String result = paymentSystem.processPayment(amount);
        assertNotNull(result, systemType + " should return a result for payment processing");
        assertTrue(expected, systemType + " processing validation");
    }
}
