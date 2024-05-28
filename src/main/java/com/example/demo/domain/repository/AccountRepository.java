package com.example.demo.domain.repository;

import com.example.demo.domain.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByName(String name);
}
