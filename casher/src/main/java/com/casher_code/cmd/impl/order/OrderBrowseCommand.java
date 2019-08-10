package com.casher_code.cmd.impl.order;

import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.CustormerCommand;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Account;
import com.casher_code.entity.Goods;
import com.casher_code.entity.Order;
import com.casher_code.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

@CommandMeta(name="LLDD",desc="浏览订单",group="订单信息")
@CustormerCommand
public class OrderBrowseCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        Account account = subject.getAccount();
        List<Order> list = this.orderService.query(account);
        if(!list.isEmpty()){
            for(Order order:list){
                System.out.println("******************订单信息********************");
                System.out.println("账户名称："+order.getAccount_name());
                System.out.println("账户ID："+order.getAccount_id());
                System.out.println("订单编号："+order.getId());
                System.out.println("订单支付状态："+(order.getOrder_status()));
                System.out.println("订单创建时间："+order.getCreate_time());
                System.out.println("********************订单明细******************");
                System.out.println("编号     名称     数量    单位     单价()");
                List<OrderItem> list1 = this.orderItemService.query(order);
                if(!list1.isEmpty())
                for(OrderItem orderItem:list1){
                    System.out.println(orderItem.getId()+". "+orderItem.getGoodsName()+" "+orderItem.getGoodsNum()+" "+orderItem.getGoodsUnit()+" "+orderItem.getGoodsPrice()/100.00);
                }else{
                    System.out.println("您目前还没有加购任何物品，请到支付订单页面加购。");
                }
                System.out.println("********************订单金额******************");
                System.out.println("订单完成时间："+order.getFinish_time());
                System.out.println("支付总金额"+order.getTotal_money()/100.0);
                System.out.println("实际支付金额："+order.getActual_amount()/100.0);
                System.out.println("*********************************************");
            }
        }else{
            System.out.println("您暂时没有订单");
            return;
        }
    }
}
