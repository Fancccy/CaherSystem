package com.casher_code.service;

import com.casher_code.dao.AccountDao;
import com.casher_code.entity.Account;

public class AccountService {
    private AccountDao accountDao;
    public AccountService(){
        this.accountDao=new AccountDao();
    }
    public Account login(String username, String password){
        return accountDao.login(username,password);
    }
    public Account regist(String username,String password,String name){
        return accountDao.regist(username,password,name);
    }
    public Account query(String username,String userId){
        return accountDao.query(username,userId);
    }
    public Account update(String username,String id,String password ){
        return accountDao.update(username,id,password);
    }
    public Account updateStatus(String username,String id){
        return accountDao.updateStatus(username,id);
    }
}
