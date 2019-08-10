package com.casher_code.cmd.impl;

import com.casher_code.entity.Account;
import com.casher_code.entity.Goods;
import lombok.Data;

@Data
public class Subject {   //定义一个类用来定义一个账户
    private Account account;
    private Goods goods;
}
