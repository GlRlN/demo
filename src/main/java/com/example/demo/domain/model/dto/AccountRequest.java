package com.example.demo.domain.model.dto;

import com.example.demo.domain.model.entity.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {
    private Long idx;

    private String id;

    private String password;

    private String name;

    public Account toEntity(){
        Account account = new Account();
        account.setIdx(this.idx);
        account.setId(this.id);
        account.setPassword(this.password);
        account.setName(this.name);
        return account;
    }

}
