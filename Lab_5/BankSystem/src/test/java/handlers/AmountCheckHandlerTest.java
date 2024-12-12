package handlers;

import org.junit.jupiter.api.Test;
import requests.TransactionRequest;

import static org.junit.jupiter.api.Assertions.*;

public class AmountCheckHandlerTest {

    @Test
    public void testExceedingPolicyLimit() {
        TransactionRequest request = new TransactionRequest(150000, 200000, true);
        TransactionHandler amountHandler = new AmountCheckHandler();

        boolean result = amountHandler.handleTransaction(request);

        assertFalse(result, "Transaction should fail due to exceeding the policy limit");
    }

    @Test
    public void testTransactionPassesWithoutVerifiedHandler() {
        BalanceCheckHandler balanceHandler = new BalanceCheckHandler();
        AmountCheckHandler amountHandler = new AmountCheckHandler();

        balanceHandler.setNext(amountHandler);
        TransactionRequest request = new TransactionRequest(5000, 20000, true);

        assertTrue(balanceHandler.handleTransaction(request), "Transaction should pass without verified handler in the chain");
    }

}
