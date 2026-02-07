package com.bank.account_service.service;

import com.bank.account_service.entity.Account;
import com.bank.account_service.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public Account getOrCreate(String username) {
        return repo.findByUsername(username)
                .orElseGet(() -> {
                    Account acc = new Account();
                    acc.setUsername(username);
                    acc.setBalance(1000.0);
                    return repo.save(acc);
                });
    }
}
