package com.casher_code.entity;

import com.casher_code.common.AccountStatus;
import com.casher_code.common.AccountType;
import lombok.Data;


@Data
public class Account {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private AccountType accountType;
    private AccountStatus accountStatus;
}
