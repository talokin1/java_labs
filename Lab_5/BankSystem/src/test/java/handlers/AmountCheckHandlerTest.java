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
}
