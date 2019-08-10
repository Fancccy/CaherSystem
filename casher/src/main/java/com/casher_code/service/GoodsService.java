package com.casher_code.service;

import com.casher_code.dao.GoodsDao;
import com.casher_code.entity.Goods;

import java.sql.ResultSet;
import java.util.List;

public class GoodsService {
    private GoodsDao goodsDao;
    public GoodsService(){
        goodsDao = new GoodsDao();
    }
    public List<Goods> query(){
       return this.goodsDao.query();
    }
    public Goods put(Goods goods){
        return this.goodsDao.put(goods);
    }
    public Goods queryOut(String name,int id){
        return this.goodsDao.queryOut(name,id);
    }
    public boolean SoldOut(String name,int id){
        return this.goodsDao.SoldOut(name, id);
    }
    public void update(int id,String name,String groupname,String message){
         this.goodsDao.update(id,name,groupname,message);
    }
    public Goods queryID(int id){
        return this.goodsDao.queryOutID(id);
    }
    public boolean updateG(int id,String name,int  message){
        return this.goodsDao.updateG(id,name,message);
    }
}
