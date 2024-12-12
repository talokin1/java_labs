package requests;

import handlers.BalanceCheckHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionRequestTest {

    @Test
    public void testTransactionRequestCreation() {
        TransactionRequest request = new TransactionRequest(5, 10, true);

        assertNotNull(request, "TransactionRequest object should be created successfully");
        assertEquals(5, request.getAmount(), "Amount should match the initialized value");
        assertEquals(10, request.getBalance(), "Balance should match the initialized value");
        assertTrue(request.isVerified(), "Verification status should match the initialized value");
    }

    @Test
    public void testTransactionWithEqualBalanceAndAmount() {
        TransactionRequest request = new TransactionRequest(5000, 5000, true);
        BalanceCheckHandler balanceHandler = new BalanceCheckHandler();
        assertTrue(balanceHandler.handleTransaction(request), "Transaction should pass when balance equals the amount");
    }

}
