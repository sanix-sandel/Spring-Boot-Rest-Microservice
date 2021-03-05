package com.example.webapp.service;

import com.example.webapp.domain.Account;
import com.example.webapp.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//import javax.security.auth.login.AccountNotFoundException;

@Service
public class WebAccountService {

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected  String serviceUrl="http://ACCOUNT-SERVICE";

    public Account getByNumber(String accountNumber){
        Account account=restTemplate.getForObject(serviceUrl +"/account/{accountId}", Account.class, accountNumber);

        if(account==null){
            throw new AccountNotFoundException(accountNumber);
        }else{
            return account;
        }
    }

    public List<Account> getAllAccounts(){
        return restTemplate.getForObject(serviceUrl+"/account", List.class);
    }

}
