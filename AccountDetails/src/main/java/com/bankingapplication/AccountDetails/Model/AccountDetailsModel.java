package com.bankingapplication.AccountDetails.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountDetailsModel {
    @Id
    private String account_no;
    private String firstname;
    private String lastname;
    private String email;
    private long contact;
}
