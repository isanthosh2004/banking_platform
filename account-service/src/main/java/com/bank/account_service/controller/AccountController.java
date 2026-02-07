package com.bank.account_service.controller;

import com.bank.account_service.entity.Account;
import com.bank.account_service.service.AccountService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/accounts/me")
    public Account myAccount(Authentication auth) {
        return service.getOrCreate(auth.getName());
    }
}
