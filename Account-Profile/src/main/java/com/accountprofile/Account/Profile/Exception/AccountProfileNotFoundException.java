package com.accountprofile.Account.Profile.Exception;

import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountProfileNotFoundException extends RuntimeException{
    public AccountProfileNotFoundException(String message) {
        super(message);


        System.out.println("mmm"+message);
    }
}
