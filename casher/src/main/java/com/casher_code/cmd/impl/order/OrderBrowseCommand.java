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

@CommandMeta(name="LLDD",desc="�������",group="������Ϣ")
@CustormerCommand
public class OrderBrowseCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        Account account = subject.getAccount();
        List<Order> list = this.orderService.query(account);
        if(!list.isEmpty()){
            for(Order order:list){
                System.out.println("******************������Ϣ********************");
                System.out.println("�˻����ƣ�"+order.getAccount_name());
                System.out.println("�˻�ID��"+order.getAccount_id());
                System.out.println("������ţ�"+order.getId());
                System.out.println("����֧��״̬��"+(order.getOrder_status()));
                System.out.println("��������ʱ�䣺"+order.getCreate_time());
                System.out.println("********************������ϸ******************");
                System.out.println("���     ����     ����    ��λ     ����()");
                List<OrderItem> list1 = this.orderItemService.query(order);
                if(!list1.isEmpty())
                for(OrderItem orderItem:list1){
                    System.out.println(orderItem.getId()+". "+orderItem.getGoodsName()+" "+orderItem.getGoodsNum()+" "+orderItem.getGoodsUnit()+" "+orderItem.getGoodsPrice()/100.00);
                }else{
                    System.out.println("��Ŀǰ��û�мӹ��κ���Ʒ���뵽֧������ҳ��ӹ���");
                }
                System.out.println("********************�������******************");
                System.out.println("�������ʱ�䣺"+order.getFinish_time());
                System.out.println("֧���ܽ��"+order.getTotal_money()/100.0);
                System.out.println("ʵ��֧����"+order.getActual_amount()/100.0);
                System.out.println("*********************************************");
            }
        }else{
            System.out.println("����ʱû�ж���");
            return;
        }
    }
}
