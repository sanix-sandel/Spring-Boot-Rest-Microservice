package com.example.webapp.controller;

import com.example.webapp.service.WebAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Autowired
    WebAccountService accountService;

    @GetMapping("/")
    String home(){
        return "home";
    }

    @GetMapping("/accounts")
    String all(ModelMap model){
        model.put("accounts", accountService.getAllAccounts());
        return "accounts";
    }
}
