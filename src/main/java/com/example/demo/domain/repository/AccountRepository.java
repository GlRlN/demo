package com.example.demo.domain.repository;

import com.example.demo.domain.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByName(String name);

    Account findByIdx(Long idx);

    @Transactional
    void deleteByIdx(Long idx);
}
