package com.accountprofile.Account.Profile.ValueObject;

import com.accountprofile.Account.Profile.Model.AccountProfileModel;
import lombok.Data;

import java.util.Optional;

@Data
public class ResponseTemplateVO {
    private AccountDetailsModel accountDetailsModel;
    private Optional<AccountProfileModel> accountProfileModel;
}
