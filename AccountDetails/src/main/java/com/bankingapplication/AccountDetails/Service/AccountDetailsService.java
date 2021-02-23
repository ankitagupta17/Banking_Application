package com.bankingapplication.AccountDetails.Service;

import com.bankingapplication.AccountDetails.Exception.AccountNotFoundException;
import com.bankingapplication.AccountDetails.Model.AccountDetailsModel;
import com.bankingapplication.AccountDetails.Repository.AccountDetailsDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AccountDetailsService {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountDetailsDAO accountDetailsDAO;

    public void addAccount(AccountDetailsModel accountDetailsModel)
    {
        logger.info("Create Account Service---->");
        accountDetailsDAO.save(accountDetailsModel);
        logger.info("account created"+accountDetailsModel.getAccount_no());
    }

    public Optional<AccountDetailsModel> getAccountDetails(String accountNumber)
    {
        Optional<AccountDetailsModel> accountDetails = accountDetailsDAO.findById(accountNumber);
        return accountDetails;
    }
}
