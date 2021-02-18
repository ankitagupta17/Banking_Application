package com.accountprofile.Account.Profile.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountProfileModel {

    @Id
    private String account_no;
    private String pin;
}
