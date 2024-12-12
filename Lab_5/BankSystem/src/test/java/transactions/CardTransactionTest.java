package transactions;

import org.junit.jupiter.api.Test;
import payment.*;


import static org.junit.jupiter.api.Assertions.*;

public class CardTransactionTest {

    @Test
    public void testCardTransactionProcessing() {
        PaymentSystem paymentSystem = new CreditCard();
        Transaction transaction = new CardTransaction(paymentSystem);

        String result = transaction.process(3000);

        assertNotNull(result, "CardTransaction should return a result");
        assertTrue(result.contains("Processing card payment"), "Result should indicate card payment processing");
        assertTrue(result.contains("CreditCard"), "Result should include payment system details");
    }
}
