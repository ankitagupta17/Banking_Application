package com.bankingapplication.AccountDetails.Repository;

import com.bankingapplication.AccountDetails.Model.AccountDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailsDAO extends JpaRepository<AccountDetailsModel, String> {
}
