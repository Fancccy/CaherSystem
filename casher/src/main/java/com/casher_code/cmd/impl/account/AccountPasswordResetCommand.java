package com.casher_code.cmd.impl.account;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Account;

@CommandMeta(
        name = "MMCZ",
        desc = "��������",
        group = "�˻���Ϣ"
)
@AdminCommand
public class AccountPasswordResetCommand extends Abstract {

    @Override
    public void execute(Subject subject) {
        System.out.println("��������Ҫ����������˻�����");
        String username = scanner.nextLine();
        System.out.println("���������˻�����Ӧ���˻�ID��");
        String id = scanner.nextLine();
        Account account = this.accountService.query(username,id);
        if(account==null){
            System.out.println("��������˻������ڣ����������룡");
            execute(subject);
        }
        System.out.println("��������Ҫ���õ����룺");
        String password = scanner.nextLine();
        if(password.trim()==null){
            System.out.println("���벻��Ϊ�գ�����������:");
            password = scanner.nextLine().trim();
        }
        System.out.println("���ٴ�ȷ�����룺");
        String password1 = scanner.nextLine();
        if(password.equals(password1)){
           this.accountService.update(username,id,password);
        }else{
            System.out.println("��������������벻һ�£����������룡");
            execute(subject);
        }

    }//�˻���������
}
