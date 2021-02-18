package com.accountprofile.Account.Profile.Resource;

import com.accountprofile.Account.Profile.Model.AccountProfileModel;
import com.accountprofile.Account.Profile.Service.AccountProfileService;
import com.accountprofile.Account.Profile.ValueObject.AccountDetailsModel;
import com.accountprofile.Account.Profile.ValueObject.ResponseTemplateVO;
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
        return accountProfileService.getProfileWithAccDetails(account_no);
    }

    @GetMapping("/getProfile/{account_no}")
    public Optional<AccountProfileModel> getUserProfile(@PathVariable String account_no)
    {
        return accountProfileService.getAccountProfile(account_no);
    }
}
