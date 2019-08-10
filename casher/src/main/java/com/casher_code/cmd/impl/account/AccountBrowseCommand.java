package com.casher_code.cmd.impl.account;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.CustormerCommand;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Account;

@CommandMeta(
        name = "CKZH",
        desc = "�鿴�˻�",
        group = "�˻���Ϣ"
)
@AdminCommand
public class AccountBrowseCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        System.out.println("��������Ҫ�鿴���˻�����");
        String username = scanner.nextLine();
        System.out.println("��������Ҫ�鿴�û���ID");
        String userId = scanner.nextLine();
        Account account = this.accountService.query(username,userId);
        if(account!=null) {
            System.out.println("***********************");
            System.out.println("�û�ID��" + account.getId());
            System.out.println("�û�����" + account.getUsername());
            System.out.println("�û�������" + account.getName());
            System.out.println("�û�״̬��" + account.getAccountStatus());
            System.out.println("�û����ͣ�" + account.getAccountType());
            System.out.println("�û����룺" + account.getPassword());
            System.out.println("************************");
        }else{
            System.out.println("Sorry!this account is not existed");
        }
    }//�˻���Ϣ���
}
