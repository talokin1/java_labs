package system;

import handlers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.*;
import requests.*;
import transactions.*;

import static org.junit.jupiter.api.Assertions.*;

public class BankingSystemTest {

    private TransactionHandler balanceHandler;
    private TransactionHandler amountHandler;
    private TransactionHandler verifiedHandler;
    private PaymentSystem paymentSystem;

    @BeforeEach
    public void setup() {
        balanceHandler = new BalanceCheckHandler();
        amountHandler = new AmountCheckHandler();
        verifiedHandler = new VerifiedHandler();

        balanceHandler.setNext(amountHandler);
        amountHandler.setNext(verifiedHandler);

        paymentSystem = new AmazonPay();
    }

    @Test
    public void testSuccessfulTransaction() {
        Transaction transaction = new BankTransfers(paymentSystem);
        TransactionRequest request = new TransactionRequest(5000, 20000, true);

        assertTrue(balanceHandler.handleTransaction(request), "Transaction should pass all checks");

        String result = transaction.process(request.getAmount());
        assertNotNull(result, "Transaction process result should not be null");
        assertTrue(result.contains("Processing bank transfer"), "Result should indicate bank transfer processing");
    }

    @Test
    public void testIncorrectHandlerOrder() {
        AmountCheckHandler amountHandler = new AmountCheckHandler();
        VerifiedHandler verifiedHandler = new VerifiedHandler();

        amountHandler.setNext(verifiedHandler);
        TransactionRequest request = new TransactionRequest(5000, 3000, true);

        assertFalse(amountHandler.handleTransaction(request), "Transaction should fail due to incorrect handler order");
    }

    @Test
    public void testSuccessfulTransactionEndToEnd() {
        PaymentSystem paymentSystem = new AmazonPay();
        Transaction transaction = new BankTransfers(paymentSystem);

        TransactionHandler balanceHandler = new BalanceCheckHandler();
        TransactionHandler amountHandler = new AmountCheckHandler();
        TransactionHandler verifiedHandler = new VerifiedHandler();

        balanceHandler.setNext(amountHandler);
        amountHandler.setNext(verifiedHandler);

        TransactionRequest request = new TransactionRequest(5000, 20000, true);

        assertTrue(balanceHandler.handleTransaction(request), "Transaction should pass all checks");

        String result = transaction.process(request.getAmount());
        assertNotNull(result, "Transaction process result should not be null");
        assertTrue(result.contains("Processing bank transfer"), "Transaction result should indicate bank transfer");
        assertTrue(result.contains("AmazonPay"), "Transaction result should include AmazonPay details");
    }

    @Test
    public void testTransactionFailsDueToUnverifiedUser() {
        PaymentSystem paymentSystem = new CreditCard();
        Transaction transaction = new CardTransaction(paymentSystem);

        TransactionHandler balanceHandler = new BalanceCheckHandler();
        TransactionHandler amountHandler = new AmountCheckHandler();
        TransactionHandler verifiedHandler = new VerifiedHandler();

        balanceHandler.setNext(amountHandler);
        amountHandler.setNext(verifiedHandler);

        TransactionRequest request = new TransactionRequest(7000, 20000, false);

        assertFalse(balanceHandler.handleTransaction(request), "Transaction should fail due to unverified user");

        String result = transaction.process(request.getAmount());
        assertFalse(result.contains("Processing card payment"), "Transaction should not process card payment");
    }



}
