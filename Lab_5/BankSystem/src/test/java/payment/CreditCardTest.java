package payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {

    @Test
    public void testCreditCardProcessing() {
        PaymentSystem paymentSystem = new CreditCard();
        String result = paymentSystem.processPayment(10000);

        assertNotNull(result, "CreditCard should return a result for payment processing");
        assertTrue(result.contains("CreditCard"), "Result should indicate that CreditCard processed the payment");
    }
}
