package com.casher_code.cmd.impl.goods;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.CustormerCommand;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Goods;

@CommandMeta(
        name = "SJSP",
        desc = "上架商品",
        group = "商品信息"
)
@AdminCommand
public class GoodsPutAwayCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        Goods goods = new Goods();
        System.out.println("*********上架商品***********");
        System.out.println("请输入商品编号");
        goods.setId(Integer.parseInt(scanner.nextLine()));
        System.out.println("请输入商品名称：");
        goods.setName(scanner.nextLine());
        System.out.println("请输入商品简介：");
        goods.setIntroduce(scanner.nextLine());
        System.out.println("请输入商品单位：（个，包，辆...）");
        goods.setUnit(scanner.nextLine());
        System.out.println("请输入商品库存：");
        goods.setStock(Integer.parseInt(scanner.nextLine()));
        System.out.println("请输入商品价格：");
        goods.setPrice(Integer.parseInt(scanner.nextLine()));
        System.out.println("请输入商品折扣：");
        goods.setDiscount(Integer.parseInt(scanner.nextLine()));
        this.goodsService.put(goods);
    }
}
