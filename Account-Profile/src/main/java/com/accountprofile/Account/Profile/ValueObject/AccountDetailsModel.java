package com.accountprofile.Account.Profile.ValueObject;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
public class AccountDetailsModel {

    @Id
    private String account_no;
    private String firstname;
    private String lastname;
    private String email;
    private long contact;
}
