package handlers;


import requests.TransactionRequest;

public class AmountCheckHandler extends TransactionHandler {

    Checks check = new Checks();

    @Override
    public boolean handleTransaction(TransactionRequest request) {
        if (check.checkAmount(request)) {
            System.out.println("Transaction exceeds the policy limit");
            return false;
        }

        System.out.println("Amount successfully checked");
        return next == null || next.handleTransaction(request);
    }

}