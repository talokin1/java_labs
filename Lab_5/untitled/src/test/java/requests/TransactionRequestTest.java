package requests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionRequestTest {

    @Test
    public void testTransactionRequestCreation() {
        TransactionRequest request = new TransactionRequest(5000, 20000, true);
        assertNotNull(request, "TransactionRequest object should be created successfully");
    }

    @Test
    public void testTransactionRequestFields() {
        TransactionRequest request = new TransactionRequest(5000, 20000, true);
        assertEquals(5000, request.getAmount(), "Amount should match the initialized value");
        assertEquals(20000, request.getBalance(), "Balance should match the initialized value");
        assertTrue(request.isVerified(), "Verification status should match the initialized value");
    }

    @ParameterizedTest
    @CsvSource({
            "5000, 20000, true",
            "10000, 15000, false",
            "0, 0, false",
            "7500, 5000, true"
    })
    public void testParameterizedTransactionRequest(double amount, double balance, boolean verified) {
        TransactionRequest request = new TransactionRequest(amount, balance, verified);
        assertEquals(amount, request.getAmount(), "Amount should match the initialized value");
        assertEquals(balance, request.getBalance(), "Balance should match the initialized value");
        assertEquals(verified, request.isVerified(), "Verification status should match the initialized value");
    }

    @Test
    public void testNegativeAmountHandling() {
        TransactionRequest request = new TransactionRequest(-5000, 20000, true);
        assertEquals(-5000, request.getAmount(), "Negative amounts should be allowed as initialized");
    }

    @Test
    public void testZeroBalanceHandling() {
        TransactionRequest request = new TransactionRequest(5000, 0, true);
        assertEquals(0, request.getBalance(), "Zero balance should be handled correctly");
    }

    @Test
    public void testUnverifiedUser() {
        TransactionRequest request = new TransactionRequest(5000, 20000, false);
        assertFalse(request.isVerified(), "Verification status should match the initialized value");
    }
}
