package com.example.webapp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.security.auth.login.AccountNotFoundException;

@ControllerAdvice
public class AccountAdviceController {

    @ExceptionHandler(AccountNotFoundException.class)
    @RequestMapping("/account/${accountId}")
    String getAccount(@PathVariable Integer accountId){
        throw new IllegalArgumentException("Getting account problem");
    }
}
