package com.casher_code.cmd.impl;

import com.casher_code.entity.Account;
import com.casher_code.entity.Goods;
import lombok.Data;

@Data
public class Subject {   //����һ������������һ���˻�
    private Account account;
    private Goods goods;
}
