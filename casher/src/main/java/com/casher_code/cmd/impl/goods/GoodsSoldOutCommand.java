package com.casher_code.cmd.impl.goods;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Goods;

@CommandMeta(
        name = "XJSP",
        desc = "�¼���Ʒ",
        group = "��Ʒ��Ϣ"
)
@AdminCommand
public class GoodsSoldOutCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        System.out.println("************�¼���Ʒ************");
        System.out.println("������������Ʒ���ƣ�");
        String name = scanner.nextLine();
        System.out.println("������������Ʒ��ţ�");
        int id = scanner.nextInt();
        Goods goods = this.goodsService.queryOut(name,id);
        if(goods!=null){
            System.out.println("**********�¼���Ʒ��Ϣ***********");
            System.out.println("��Ʒ���ƣ�"+goods.getName());
            System.out.println("��Ʒ��ţ�"+goods.getId());
            System.out.println("��Ʒ��飺"+goods.getIntroduce());
            System.out.println("��Ʒ��棺"+goods.getStock());
            System.out.println("��浥λ��"+goods.getUnit());
            System.out.println("��Ʒ�۸�"+goods.getPrice());
            System.out.println("��Ʒ�ۿۣ�"+(goods.getPrice()/10+"��"));
            System.out.println("��ȷ��Ҫ�¼���   1ȷ��  2����");
            int re = scanner.nextInt();
            if(re==1){
               boolean flg = this.goodsService.SoldOut(name,id);
               if(flg){
                   System.out.println("�¼���Ʒ�ɹ�");
               }else{
                   System.out.println("�¼���Ʒʧ��");
               }
            }else if(re==2){
                return;
            }else {
                System.out.println("ָ����������");
            }
        }else{
            System.out.println("���������Ʒ�����ڣ�����������");
            return;
        }
    }
}
