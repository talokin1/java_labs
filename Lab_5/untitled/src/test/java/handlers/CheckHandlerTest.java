package handlers;

import requests.TransactionRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.*;

public class CheckHandlerTest {

    private TransactionHandler balanceHandler;
    private TransactionHandler amountHandler;
    private TransactionHandler verifiedHandler;

    @BeforeEach
    public void setup() {
        balanceHandler = new BalanceCheckHandler();
        amountHandler = new AmountCheckHandler();
        verifiedHandler = new VerifiedHandler();

        balanceHandler.setNext(amountHandler);
        amountHandler.setNext(verifiedHandler);
    }

    @Test
    public void testTransactionPassesAllChecks() {
        TransactionRequest request = new TransactionRequest(5000, 20000, true);
        boolean resultBalance = balanceHandler.handleTransaction(request);
        boolean resultAmount = amountHandler.handleTransaction(request);
        boolean resultVerified = verifiedHandler.handleTransaction(request);
        assertTrue(resultBalance, "Transaction should pass all checks");
        assertTrue(resultAmount, "Amount should pass all checks");
        assertTrue(resultVerified, "Verified Transaction should pass all checks");
    }

    @Test
    public void testTransactionFailsBalanceCheck() {
        TransactionRequest request = new TransactionRequest(5000, 3000, true);
        boolean result = balanceHandler.handleTransaction(request);
        assertFalse(result, "Transaction should fail due to insufficient balance");
    }

    @Test
    public void testTransactionFailsAmountCheck() {
        TransactionRequest request = new TransactionRequest(150000, 200000, true);
        boolean result = amountHandler.handleTransaction(request);
        assertFalse(result, "Transaction should fail due to exceeding policy limit");
    }

    @Test
    public void testTransactionFailsVerifiedCheck() {
        TransactionRequest request = new TransactionRequest(5000, 20000, false);
        boolean result = verifiedHandler.handleTransaction(request);
        assertFalse(result, "Transaction should fail due to unverified user");
    }
}

