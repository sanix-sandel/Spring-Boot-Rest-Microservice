package com.example.accountservice.repository;

import com.example.accountservice.domain.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    List<Account> findAllByCustomerId(Integer customerId);

    List<Account> findAllByAccountType(String accountType);

    List<Account> findByBank(String bank);

    Account findAccountByAccountId(Integer accountId);
}
