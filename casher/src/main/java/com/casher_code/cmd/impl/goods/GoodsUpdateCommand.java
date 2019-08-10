package com.casher_code.cmd.impl.goods;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Goods;

@CommandMeta(
        name = "GXSP",
        desc = "更新商品",
        group = "商品信息"
)
@AdminCommand
public class GoodsUpdateCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        System.out.println("************更新商品*************");
        System.out.println("请输入您要更新的商品编号：");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("请输入您要更新的商品名称：");
        String name = scanner.nextLine();
        Goods goods = this.goodsService.queryOut(name,id);
        if(goods==null){
            System.out.println("您输入的商品不存在，请重新输入！");
            return;
        }
        System.out.println("**************商品原信息*************");
        System.out.println("商品名称："+goods.getName());
        System.out.println("商品编号："+goods.getId());
        System.out.println("商品简介："+goods.getIntroduce());
        System.out.println("商品库存："+goods.getStock());
        System.out.println("库存单位："+goods.getUnit());
        System.out.println("商品价格："+goods.getPrice());
        System.out.println("商品折扣："+(goods.getDiscount()/10.00)+"折");
        System.out.println("*************************************");
        System.out.println("您确定要更新吗？  1 确定 2 返回");
        if(Integer.parseInt(scanner.nextLine())==1){
            this.goodsService.SoldOut(name,id);
            System.out.println("请输入您要更新的商品信息： ");
            new GoodsPutAwayCommand().execute(subject);
        }
    }

}
