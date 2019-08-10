package com.casher_code.cmd.impl.order;

import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.CustormerCommand;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.common.OrderStatus;
import com.casher_code.entity.Account;
import com.casher_code.entity.Goods;
import com.casher_code.entity.Order;
import com.casher_code.entity.OrderItem;
import lombok.Builder;
import org.apache.commons.lang.RandomStringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.apache.commons.lang.RandomStringUtils.random;

@CommandMeta(name="ZFDD",desc="֧������",group="������Ϣ")
@CustormerCommand
public class OrderPayCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        Account account = subject.getAccount();
        int account_id = account.getId();
        Order order = null;
        order = this.orderService.queryID(account);
        String order_id = null;
        if (order==null || order.getOrder_status() == OrderStatus.PAY) {
            order_id = String.valueOf(System.currentTimeMillis());
            order = this.orderService.insert(account, 0, 0,order_id);
            Goods goods = null;
            System.out.println("������Ҫ����Ļ���Id�Լ��������������֮�䡰,������,��ʽ��1-3,7-2");
            String choice = scanner.nextLine();
            String[] good = choice.split(",");
            double count = 0;
            double rcount = 0;
            for (String a : good) {
                String[] message = a.split("-");
                String goods_id = message[0];
                String goods_num = message[1];
                goods = this.goodsService.queryID(Integer.parseInt(goods_id));
                if (goods != null) {
                    if (goods.getStock() == 0) {
                        System.out.println("�˻����Ѿ�û�п�棡");
                    } else {
                        this.goodsService.updateG(goods.getId(), goods.getName(), (goods.getStock() - Integer.parseInt(goods_num)));
                        System.out.println(goods.getPrice());
                        this.orderItemService.put(goods, order, Integer.parseInt(goods_num));
                        count += (goods.getPrice()) * Integer.parseInt(goods_num);
                        rcount += count * (goods.getDiscount() / 100.0);
                    }
                }else{
                    System.out.println("�˻��ﲻ����");
                }
            }
           this.orderService.updateT(account, count, rcount);
        }
        order = this.orderService.queryOut(order_id);
        System.out.println("******************������Ϣ********************");
        System.out.println("�˻����ƣ�"+order.getAccount_name());
        System.out.println("�˻�ID��"+order.getAccount_id());
        System.out.println("������ţ�"+order.getId());
        System.out.println("����֧��״̬��"+(order.getOrder_status()));
        System.out.println("��������ʱ�䣺"+order.getCreate_time());
        System.out.println("********************������ϸ******************");
        System.out.println("���     ����     ����    ��λ     ����()");
        List<OrderItem> list1 = this.orderItemService.query(order);
        if(!list1.isEmpty()){
            for(OrderItem orderItem:list1){
                System.out.println(orderItem.getId()+". "+orderItem.getGoodsName()+" "+orderItem.getGoodsNum()+" "+orderItem.getGoodsUnit()+" "+orderItem.getGoodsPrice()/100.00);
            }
        } else{
            System.out.println("��Ŀǰ��û�мӹ��κ���Ʒ���뵽֧������ҳ��ӹ���");
        }
        System.out.println("********************�������******************");
        System.out.println("�������ʱ�䣺"+order.getFinish_time());
        System.out.println("֧���ܽ��"+order.getTotal_money()/100.0);
        System.out.println("ʵ��֧����"+order.getActual_amount()/100.0);
        System.out.println("*********************************************");
        System.out.println("�Ƿ�֧������  1 ȷ��֧��  2 ȡ��֧��");
        String res = scanner.nextLine();
        if (res.equals("1")) {
            boolean a = this.orderService.update(account, 2, new java.sql.Timestamp(new Date().getTime()));
            if (a) {
                System.out.println("֧���ɹ�");
            } else {
                System.out.println("֧��ʧ��");
            }
        } else {
            this.orderService.update(account, 1, new java.sql.Timestamp(new Date().getTime()));
            return;
       }
    }
}
