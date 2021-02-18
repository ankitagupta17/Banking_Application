package com.accountprofile.Account.Profile.Repository;

import com.accountprofile.Account.Profile.Model.AccountProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountProfileDAO extends JpaRepository<AccountProfileModel, String> {
}
