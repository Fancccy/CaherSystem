package com.casher_code.service;

import com.casher_code.dao.OrderDao;
import com.casher_code.entity.Account;
import com.casher_code.entity.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public class OrderService {
    private OrderDao orderDao = null;
    public OrderService(){
        orderDao = new OrderDao();
    }
    public List<Order> query(Account account){
        return this.orderDao.query( account);
    }
    public Order queryID(Account account){
        return this.orderDao.queryOutID(account);
    }
    public Order insert(Account account, int actual_amount, int total_money, String id){
        return this.orderDao.insert(account,actual_amount,total_money,id);
    }
    public boolean update(Account account, int i,java.sql.Timestamp a){
        return this.orderDao.update(account,i,a);
    }
    public boolean updateT(Account account, double count,double rcount){
        return this.orderDao.updateT(account,count,rcount);
    }
    public Order queryOut(String id){
        return this.orderDao.queryOut(id);
    }
}
