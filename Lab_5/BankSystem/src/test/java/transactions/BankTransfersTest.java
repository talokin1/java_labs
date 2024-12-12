package transactions;

import org.junit.jupiter.api.Test;
import payment.AmazonPay;
import payment.PaymentSystem;

import static org.junit.jupiter.api.Assertions.*;

public class BankTransfersTest {

    @Test
    public void testBankTransferProcessing() {
        PaymentSystem paymentSystem = new AmazonPay();
        Transaction transaction = new BankTransfers(paymentSystem);

        String result = transaction.process(5000);

        assertNotNull(result, "BankTransferTransaction should return a result");
        assertTrue(result.contains("Processing bank transfer"), "Result should indicate bank transfer processing");
        assertTrue(result.contains("AmazonPay"), "Result should include payment system details");
    }
}
