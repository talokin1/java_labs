package payment;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class StripeTest {

    @Test
    public void testStripeProcessing() {
        PaymentSystem paymentSystem = new Stripe();
        String result = paymentSystem.processPayment(7500);

        assertNotNull(result, "Stripe should return a result for payment processing");
        assertTrue(result.contains("Stripe"), "Result should indicate that Stripe processed the payment");
    }
}
