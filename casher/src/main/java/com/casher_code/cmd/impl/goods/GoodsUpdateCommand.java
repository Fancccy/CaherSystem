package com.casher_code.cmd.impl.goods;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Goods;

@CommandMeta(
        name = "GXSP",
        desc = "������Ʒ",
        group = "��Ʒ��Ϣ"
)
@AdminCommand
public class GoodsUpdateCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        System.out.println("************������Ʒ*************");
        System.out.println("��������Ҫ���µ���Ʒ��ţ�");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("��������Ҫ���µ���Ʒ���ƣ�");
        String name = scanner.nextLine();
        Goods goods = this.goodsService.queryOut(name,id);
        if(goods==null){
            System.out.println("���������Ʒ�����ڣ����������룡");
            return;
        }
        System.out.println("**************��Ʒԭ��Ϣ*************");
        System.out.println("��Ʒ���ƣ�"+goods.getName());
        System.out.println("��Ʒ��ţ�"+goods.getId());
        System.out.println("��Ʒ��飺"+goods.getIntroduce());
        System.out.println("��Ʒ��棺"+goods.getStock());
        System.out.println("��浥λ��"+goods.getUnit());
        System.out.println("��Ʒ�۸�"+goods.getPrice());
        System.out.println("��Ʒ�ۿۣ�"+(goods.getDiscount()/10.00)+"��");
        System.out.println("*************************************");
        System.out.println("��ȷ��Ҫ������  1 ȷ�� 2 ����");
        if(Integer.parseInt(scanner.nextLine())==1){
            this.goodsService.SoldOut(name,id);
            System.out.println("��������Ҫ���µ���Ʒ��Ϣ�� ");
            new GoodsPutAwayCommand().execute(subject);
        }
    }

}
