package com.casher_code.cmd.impl.goods;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Goods;

@CommandMeta(
        name = "XJSP",
        desc = "下架商品",
        group = "商品信息"
)
@AdminCommand
public class GoodsSoldOutCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        System.out.println("************下架商品************");
        System.out.println("请输入您的商品名称：");
        String name = scanner.nextLine();
        System.out.println("请输入您的商品编号：");
        int id = scanner.nextInt();
        Goods goods = this.goodsService.queryOut(name,id);
        if(goods!=null){
            System.out.println("**********下架商品信息***********");
            System.out.println("商品名称："+goods.getName());
            System.out.println("商品编号："+goods.getId());
            System.out.println("商品简介："+goods.getIntroduce());
            System.out.println("商品库存："+goods.getStock());
            System.out.println("库存单位："+goods.getUnit());
            System.out.println("商品价格："+goods.getPrice());
            System.out.println("商品折扣："+(goods.getPrice()/10+"折"));
            System.out.println("您确定要下架吗？   1确定  2返回");
            int re = scanner.nextInt();
            if(re==1){
               boolean flg = this.goodsService.SoldOut(name,id);
               if(flg){
                   System.out.println("下架商品成功");
               }else{
                   System.out.println("下架商品失败");
               }
            }else if(re==2){
                return;
            }else {
                System.out.println("指令输入有误");
            }
        }else{
            System.out.println("您输入的商品不存在，请重新输入");
            return;
        }
    }
}
