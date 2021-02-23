package com.accountprofile.Account.Profile.Service;

import com.accountprofile.Account.Profile.Exception.AccountProfileNotFoundException;
import com.accountprofile.Account.Profile.Model.AccountProfileModel;
import com.accountprofile.Account.Profile.Repository.AccountProfileDAO;
import com.accountprofile.Account.Profile.ValueObject.AccountDetailsModel;
import com.accountprofile.Account.Profile.ValueObject.ResponseTemplateVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountProfileService{

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountProfileDAO accountProfileDAO;

    @Autowired
    private RestTemplate restTemplate;

    public void addAccount(AccountDetailsModel accountDetailsModel)
    {
        String acc_no=accountDetailsModel.getAccount_no();
        AccountProfileModel newacc=restTemplate.postForObject("http://COUNTRIES-SERVICE/users/createAccount", accountDetailsModel, AccountProfileModel.class);
        logger.info("created Account-----");
    }

    public void addProfile(String newAccount_no)
    {
        Random random=new Random();
        String pin=String.format("%04d", random.nextInt(10000));
        AccountProfileModel newProfile=new AccountProfileModel(newAccount_no, pin);
        accountProfileDAO.save(newProfile);
    }

    public Optional<AccountProfileModel> getAccountProfile(String account_no)
    {
        logger.info("fetch user profile data");
        return accountProfileDAO.findById(account_no);
    }

    public List<AccountProfileModel> getAllProfile()
    {
        return accountProfileDAO.findAll();
    }

    public ResponseTemplateVO getProfileWithAccDetails(String account_no)
    {
        ResponseTemplateVO responseTemplateVO= new ResponseTemplateVO();
        Optional<AccountProfileModel> accountProfileModel=accountProfileDAO.findById(account_no);
        AccountDetailsModel accountDetailsModel=restTemplate.getForObject("http://COUNTRIES-SERVICE/users/"+account_no,AccountDetailsModel.class);
        responseTemplateVO.setAccountDetailsModel(accountDetailsModel);
        responseTemplateVO.setAccountProfileModel(accountProfileModel);
        return responseTemplateVO;
    }
    
}
