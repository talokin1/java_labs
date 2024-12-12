package handlers;

import requests.TransactionRequest;

public class Checks {

    public boolean checkBalance(TransactionRequest request) {
        return request.getBalance() < request.getAmount();
    }

    public boolean checkAmount(TransactionRequest request) {
        return request.getAmount() > 100_000;
    }

    public boolean checkVerified(TransactionRequest request) {
        return !request.isVerified();
    }
}