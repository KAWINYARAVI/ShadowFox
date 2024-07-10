package com.example.account.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        // Implement account creation logic
        return accountRepository.save(account);
    }

    public Account getAccount(String accountNumber) {
        // Implement logic to fetch account by account number
        return accountRepository.findByAccountNumber(accountNumber);
    }

    // Implement other account management methods (update, delete, etc.)
}
