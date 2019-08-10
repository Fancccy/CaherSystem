package com.casher_code.cmd.impl.goods;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.CustormerCommand;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@CommandMeta(name="LLSP",desc="浏览商品",group="商品信息")
@AdminCommand
@CustormerCommand

public class GoodsBrowseCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        List<Goods> list = this.goodsService.query();  //将所拥有的商品都存进一个
      if(!list.isEmpty()){
          for(Goods goods:list){
              System.out.println("*************商品信息************");
              System.out.println("商品名称："+goods.getName());
              System.out.println("商品编号："+goods.getId());
              System.out.println("商品简介："+goods.getIntroduce());
              System.out.println("商品库存："+goods.getStock());
              System.out.println("库存单位："+goods.getUnit());
              System.out.println("商品价格："+goods.getPrice());
              System.out.println("商品折扣："+(goods.getDiscount()/10.00)+"折");
              System.out.println("*********************************");
          }

      } else {
          System.out.println("货物已空");
      }
    }

}
