package transactions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import payment.*;


import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @ParameterizedTest
    @CsvSource({
            "BankTransfer, AmazonPay, 5000, Processing bank transfer",
            "CardTransaction, CreditCard, 3000, Processing card payment"
    })
    public void testTransactionProcessing(String transactionType, String paymentSystemType, double amount, String expected) {
        PaymentSystem paymentSystem;
        Transaction transaction;

        paymentSystem = switch (paymentSystemType) {
            case "AmazonPay" -> new AmazonPay();
            case "CreditCard" -> new CreditCard();
            default -> throw new IllegalArgumentException("Unknown payment system: " + paymentSystemType);
        };

        transaction = switch (transactionType) {
            case "BankTransfer" -> new BankTransfers(paymentSystem);
            case "CardTransaction" -> new CardTransaction(paymentSystem);
            default -> throw new IllegalArgumentException("Unknown transaction type: " + transactionType);
        };

        String result = transaction.process(amount);

        assertNotNull(result, "Transaction process result should not be null");
        assertTrue(result.contains(expected), "Result should indicate correct transaction processing");
        assertTrue(result.contains(paymentSystemType), "Result should include payment system details");
    }
}
