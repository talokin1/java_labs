package handlers;

import requests.TransactionRequest;

public class BalanceCheckHandler extends TransactionHandler {

    Checks check = new Checks();

    @Override
    public boolean handleTransaction(TransactionRequest request) {
        if (check.checkBalance(request)) {
            System.out.println("Insufficient funds on the balance sheet");
            return false;
        }

        System.out.println("Balance successful checked");
        return next == null || next.handleTransaction(request);

    }

}
