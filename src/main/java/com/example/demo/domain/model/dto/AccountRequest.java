package com.example.demo.domain.model.dto;

import com.example.demo.domain.model.entity.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
public class AccountRequest {
    private Long idx;

    @Setter
    private String id;

    @Setter
    private String password;

    @Setter
    private String name;

    public Account toEntity(){
        Account account = new Account();
        account.setId(this.id);
        account.setPassword(this.password);
        account.setName(this.name);
        return account;
    }

    public Account toEntity(Long idx, String id, String password, String name){
        Account account = new Account();
        account.setIdx(idx);
        account.setId(id);
        account.setPassword(password);
        account.setName(name);
        return account;
    }
}
