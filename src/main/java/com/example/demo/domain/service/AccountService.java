package com.example.demo.domain.service;

import com.example.demo.domain.model.dto.AccountRequest;
import com.example.demo.domain.model.entity.Account;
import com.example.demo.domain.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void save(AccountRequest accountRequest) {
        accountRepository.save(accountRequest.toEntity());
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
