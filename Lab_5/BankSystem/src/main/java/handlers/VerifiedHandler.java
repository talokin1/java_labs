package handlers;

import requests.TransactionRequest;

public class VerifiedHandler extends TransactionHandler {

    Checks check = new Checks();

    @Override
    public boolean handleTransaction(TransactionRequest request) {
        if (check.checkVerified(request)) {
            System.out.println("User is not verified");
            return false;
        }

        System.out.println("User is verified");
        return next == null || next.handleTransaction(request);
    }
}