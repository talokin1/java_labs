package payment;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AmazonPayTest {

    @Test
    public void testAmazonPayProcessing() {
        PaymentSystem paymentSystem = new AmazonPay();
        String result = paymentSystem.processPayment(5000);

        assertNotNull(result, "AmazonPay should return a result for payment processing");
        assertTrue(result.contains("AmazonPay"), "Result should indicate that AmazonPay processed the payment");
    }
}
