package com.bankingapplication.AccountDetails.Exception;


public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String message) {
        super(message);
    }
}
