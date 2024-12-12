package handlers;

import org.junit.jupiter.api.Test;
import requests.TransactionRequest;

import static org.junit.jupiter.api.Assertions.*;

public class BalanceCheckHandlerTest {

    @Test
    public void testInsufficientBalance() {
        TransactionRequest request = new TransactionRequest(5000, 3000, true);
        TransactionHandler balanceHandler = new BalanceCheckHandler();

        boolean result = balanceHandler.handleTransaction(request);

        assertFalse(result, "Transaction should fail due to insufficient balance");
    }

    @Test
    public void testTransactionFailsWithoutChain() {
        BalanceCheckHandler handler = new BalanceCheckHandler();
        TransactionRequest request = new TransactionRequest(5000, 3000, true);

        assertFalse(handler.handleTransaction(request), "Transaction should fail without a proper chain setup");
    }


}
