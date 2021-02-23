package com.accountprofile.Account.Profile.Resource;

import com.accountprofile.Account.Profile.Exception.AccountDetailsNotFoundException;
import com.accountprofile.Account.Profile.Exception.AccountProfileNotFoundException;
import com.accountprofile.Account.Profile.Model.AccountProfileModel;
import com.accountprofile.Account.Profile.Service.AccountProfileService;
import com.accountprofile.Account.Profile.ValueObject.AccountDetailsModel;
import com.accountprofile.Account.Profile.ValueObject.ResponseTemplateVO;
import org.apache.http.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banking")
public class AccountProfileController {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    AccountProfileService accountProfileService;

    @PostMapping("/createAccountWithProfile")
    public void createAccount(@RequestBody AccountDetailsModel accountDetailsModel)
    {
        logger.info("create with controller");
        accountProfileService.addAccount(accountDetailsModel);
        logger.info("new account----");
        accountProfileService.addProfile(accountDetailsModel.getAccount_no());
    }

    @GetMapping("/getAllProfiles")
    public List<AccountProfileModel> getAllProfile()
    {
        return accountProfileService.getAllProfile();
    }

    @GetMapping("/{account_no}")
    public ResponseTemplateVO getAccountInfoByAccNo(@PathVariable String account_no)
    {
        ResponseTemplateVO accountInfo=accountProfileService.getProfileWithAccDetails(account_no);
        System.out.println("ankita"+accountProfileService.getProfileWithAccDetails(account_no));
        if(accountInfo.getAccountDetailsModel()==null)
        {
            throw new AccountDetailsNotFoundException("There does not exist a user with account number "+account_no);
        }
        return accountInfo;
    }

    @GetMapping("/getProfile/{account_no}")
    public Optional<AccountProfileModel> getUserProfile(@PathVariable String account_no) {
        Optional<AccountProfileModel> accountProfile= accountProfileService.getAccountProfile(account_no);
        if(accountProfile.isEmpty())
        {
            throw new AccountProfileNotFoundException("Account Profile not found with account number "+account_no);
        }
        return accountProfile;
    }
}
