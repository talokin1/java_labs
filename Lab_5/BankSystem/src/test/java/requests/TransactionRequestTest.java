package tests.requests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import requests.TransactionRequest;

public class TransactionRequestTest {

    @Test
    public void testTransactionRequestCreation() {
        TransactionRequest request = new TransactionRequest(5000, 20000, true);

        assertNotNull(request, "TransactionRequest object should be created successfully");
        assertEquals(5000, request.getAmount(), "Amount should match the initialized value");
        assertEquals(20000, request.getBalance(), "Balance should match the initialized value");
        assertTrue(request.isVerified(), "Verification status should match the initialized value");
    }
}
