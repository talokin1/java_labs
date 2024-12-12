package system;

import handlers.BalanceCheckHandler;
import handlers.AmountCheckHandler;
import handlers.TransactionHandler;
import handlers.VerifiedHandler;
import payment.AmazonPay;
import payment.PaymentSystem;
import requests.TransactionRequest;
import transactions.BankTransferTransaction;
import transactions.Transaction;

public class BankingSystem {
    public static void main(String[] args) {
        PaymentSystem paymentSystem = new AmazonPay();

        Transaction transaction = new BankTransferTransaction(paymentSystem);

        TransactionHandler balanceHandler = new BalanceCheckHandler();
        TransactionHandler amountHandler = new AmountCheckHandler();
        TransactionHandler verifiedHandler = new VerifiedHandler();

        balanceHandler.setNext(amountHandler);
        amountHandler.setNext(verifiedHandler);

        TransactionRequest request = new TransactionRequest(5000, 20000, true);

        if (balanceHandler.handleTransaction(request)) {
            System.out.println(transaction.process(request.getAmount()));
        } else {
            System.out.println("Transaction denied");
        }
    }
}