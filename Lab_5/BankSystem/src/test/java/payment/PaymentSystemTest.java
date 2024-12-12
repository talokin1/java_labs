package payment;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

public class PaymentSystemTest {

    @ParameterizedTest
    @CsvSource({
            "AmazonPay, 5000",
            "CreditCard, 10000",
            "PayPal, 1500",
            "Stripe, 7500"
    })
    public void testPaymentSystemProcessing(String systemType, double amount) {
        PaymentSystem paymentSystem = switch (systemType) {
            case "AmazonPay" -> new AmazonPay();
            case "CreditCard" -> new CreditCard();
            case "PayPal" -> new PayPal();
            case "Stripe" -> new Stripe();
            default -> throw new IllegalArgumentException("Unknown payment system: " + systemType);
        };

        String result = paymentSystem.processPayment(amount);
        assertNotNull(result, systemType + " should return a result for payment processing");
        assertTrue(result.contains(systemType), systemType + " processing validation");
    }
}
