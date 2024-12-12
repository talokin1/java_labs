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
}
