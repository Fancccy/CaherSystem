package com.casher_code.cmd.impl.account;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.common.AccountStatus;
import com.casher_code.entity.Account;

@CommandMeta(
        name = "QTZH",
        desc = "��ͣ�˻�",
        group = "�˻���Ϣ"
)
@AdminCommand
public class AccountStatusSetCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        System.out.println("��������Ҫ��ͣ���˻���");
        String username = scanner.nextLine();
        System.out.println("��������Ҫ��ͣ���˻�ID");
        String id = scanner.nextLine();
        Account account = this.accountService.query(username,id);
        if(account==null){
            System.out.println("���û������ڣ������������û���Ϣ��");
            execute(subject);
        }else{
            if(account.getAccountStatus()==AccountStatus.LOCK ){
                System.out.println("���˻��Ѿ���ͣ");
            }
            this.accountService.updateStatus(username,id);
        }
    }//�˻�״̬����
}
