package com.example.accountservice.controller;

import com.example.accountservice.domain.Account;
import com.example.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping(value="/account")
    public Account save(@RequestBody Account account){
        return accountRepository.save(account);
    }

    @GetMapping(value="/account")
    public Iterable<Account> all(){
        return accountRepository.findAll();
    }

    @GetMapping(value="/account/{accountId}")
    public Account findByAccountId(@PathVariable Integer accountId){
        return accountRepository.findAccountByAccountId(accountId);
    }

    @PutMapping(value="/account")
    public Account update(@RequestBody Account account){
        return accountRepository.save(account);
    }

    @DeleteMapping("/account")
    public void delete(@RequestBody Account account){
        accountRepository.delete(account);
    }

}
