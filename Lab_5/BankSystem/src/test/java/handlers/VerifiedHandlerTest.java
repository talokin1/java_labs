package tests.handlers;

import handlers.TransactionHandler;
import handlers.VerifiedHandler;
import org.junit.jupiter.api.Test;
import requests.TransactionRequest;

import static org.junit.jupiter.api.Assertions.*;

public class VerifiedHandlerTest {

    @Test
    public void testUnverifiedUser() {
        TransactionRequest request = new TransactionRequest(5000, 20000, false);
        TransactionHandler verifiedHandler = new VerifiedHandler();

        boolean result = verifiedHandler.handleTransaction(request);

        assertFalse(result, "Transaction should fail due to unverified user");
    }
}
