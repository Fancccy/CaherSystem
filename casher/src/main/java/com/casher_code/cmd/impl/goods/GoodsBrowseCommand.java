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

@CommandMeta(name="LLSP",desc="�����Ʒ",group="��Ʒ��Ϣ")
@AdminCommand
@CustormerCommand

public class GoodsBrowseCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        List<Goods> list = this.goodsService.query();  //����ӵ�е���Ʒ�����һ��
      if(!list.isEmpty()){
          for(Goods goods:list){
              System.out.println("*************��Ʒ��Ϣ************");
              System.out.println("��Ʒ���ƣ�"+goods.getName());
              System.out.println("��Ʒ��ţ�"+goods.getId());
              System.out.println("��Ʒ��飺"+goods.getIntroduce());
              System.out.println("��Ʒ��棺"+goods.getStock());
              System.out.println("��浥λ��"+goods.getUnit());
              System.out.println("��Ʒ�۸�"+goods.getPrice());
              System.out.println("��Ʒ�ۿۣ�"+(goods.getDiscount()/10.00)+"��");
              System.out.println("*********************************");
          }

      } else {
          System.out.println("�����ѿ�");
      }
    }

}
