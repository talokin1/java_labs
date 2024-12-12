package system;

import handlers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.AmazonPay;
import payment.PaymentSystem;
import requests.TransactionRequest;
import transactions.BankTransferTransaction;
import transactions.CardTransaction;
import transactions.Transaction;

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
        Transaction transaction = new BankTransferTransaction(paymentSystem);
        TransactionRequest request = new TransactionRequest(5000, 20000, true);

        assertTrue(balanceHandler.handleTransaction(request), "Transaction should pass all checks");

        String result = transaction.process(request.getAmount());
        assertNotNull(result, "Transaction process result should not be null");
        assertTrue(result.contains("Processing bank transfer"), "Transaction should process bank transfer");
    }

    @Test
    public void testFailedTransactionDueToInsufficientBalance() {
        Transaction transaction = new BankTransferTransaction(paymentSystem);
        TransactionRequest request = new TransactionRequest(5000, 3000, true);

        assertFalse(balanceHandler.handleTransaction(request), "Transaction should fail due to insufficient balance");
    }

    @Test
    public void testFailedTransactionDueToExceedingAmountLimit() {
        Transaction transaction = new BankTransferTransaction(paymentSystem);
        TransactionRequest request = new TransactionRequest(150000, 200000, true);

        assertFalse(balanceHandler.handleTransaction(request), "Transaction should fail due to exceeding amount limit");
    }

    @Test
    public void testFailedTransactionDueToUnverifiedUser() {
        Transaction transaction = new BankTransferTransaction(paymentSystem);
        TransactionRequest request = new TransactionRequest(5000, 20000, false);

        assertFalse(balanceHandler.handleTransaction(request), "Transaction should fail due to unverified user");
    }

    @Test
    public void testCardTransactionProcessing() {
        Transaction transaction = new CardTransaction(paymentSystem);
        TransactionRequest request = new TransactionRequest(3000, 20000, true);

        assertTrue(balanceHandler.handleTransaction(request), "Transaction should pass all checks");

        String result = transaction.process(request.getAmount());
        assertNotNull(result, "Transaction process result should not be null");
        assertTrue(result.contains("Processing card payment"), "Transaction should process card payment");
    }

    @Test
    public void testTransactionWithBoundaryAmount() {
        Transaction transaction = new BankTransferTransaction(paymentSystem);
        TransactionRequest request = new TransactionRequest(100000, 200000, true);

        assertTrue(balanceHandler.handleTransaction(request), "Transaction should pass for boundary amount");

        String result = transaction.process(request.getAmount());
        assertNotNull(result, "Transaction process result should not be null");
    }

    @Test
    public void testTransactionFailsAtHandlerChainMiddle() {
        Transaction transaction = new BankTransferTransaction(paymentSystem);
        TransactionRequest request = new TransactionRequest(100000, 90000, true);

        assertFalse(balanceHandler.handleTransaction(request), "Transaction should fail at amount handler check");
    }
}
