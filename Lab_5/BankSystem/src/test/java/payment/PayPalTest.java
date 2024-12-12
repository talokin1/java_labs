package payment;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class PayPalTest {

    @Test
    public void testPayPalProcessing() {
        PaymentSystem paymentSystem = new PayPal();
        String result = paymentSystem.processPayment(1500);

        assertNotNull(result, "PayPal should return a result for payment processing");
        assertTrue(result.contains("PayPal"), "Result should indicate that PayPal processed the payment");
    }
}
