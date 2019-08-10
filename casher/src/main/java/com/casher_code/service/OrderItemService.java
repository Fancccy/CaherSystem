package com.casher_code.service;


import com.casher_code.dao.OrderItemDao;
import com.casher_code.entity.Account;
import com.casher_code.entity.Goods;
import com.casher_code.entity.Order;
import com.casher_code.entity.OrderItem;

import java.util.List;

public class OrderItemService {
    private OrderItemDao orderItemDao;
    public OrderItemService(){
        this.orderItemDao = new OrderItemDao();
    }
    public List<OrderItem> query(Order order){
        return this.orderItemDao.query(order);
    }
    public OrderItem put(Goods goods ,Order order,int goods_num){
        return this.orderItemDao.put(goods,order,goods_num);
    }

}
