package com.casher_code.cmd.impl.goods;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.CustormerCommand;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Goods;

@CommandMeta(
        name = "SJSP",
        desc = "�ϼ���Ʒ",
        group = "��Ʒ��Ϣ"
)
@AdminCommand
public class GoodsPutAwayCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        Goods goods = new Goods();
        System.out.println("*********�ϼ���Ʒ***********");
        System.out.println("��������Ʒ���");
        goods.setId(Integer.parseInt(scanner.nextLine()));
        System.out.println("��������Ʒ���ƣ�");
        goods.setName(scanner.nextLine());
        System.out.println("��������Ʒ��飺");
        goods.setIntroduce(scanner.nextLine());
        System.out.println("��������Ʒ��λ��������������...��");
        goods.setUnit(scanner.nextLine());
        System.out.println("��������Ʒ��棺");
        goods.setStock(Integer.parseInt(scanner.nextLine()));
        System.out.println("��������Ʒ�۸�");
        goods.setPrice(Integer.parseInt(scanner.nextLine()));
        System.out.println("��������Ʒ�ۿۣ�");
        goods.setDiscount(Integer.parseInt(scanner.nextLine()));
        this.goodsService.put(goods);
    }
}
