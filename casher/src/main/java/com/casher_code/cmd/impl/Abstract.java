package com.casher_code.cmd.impl;

import com.casher_code.service.AccountService;
import com.casher_code.service.GoodsService;
import com.casher_code.service.OrderItemService;
import com.casher_code.service.OrderService;

public abstract class Abstract implements Command {
    //�������еķ���(�����ࣩ

    public AccountService accountService;
    public GoodsService goodsService;
    public OrderService orderService;
    public OrderItemService orderItemService;
    public  Abstract(){
        this.accountService = new AccountService();
        this.goodsService = new GoodsService();
        this.orderService = new OrderService();
        this.orderItemService = new OrderItemService();
    }
}
