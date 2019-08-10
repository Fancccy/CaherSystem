package com.casher_code.cmd.impl.entrance;

import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.EntranceCommand;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.common.AccountStatus;
import com.casher_code.entity.Account;

import java.sql.SQLOutput;

@CommandMeta(name="DL",desc="��¼",group="�������")
@EntranceCommand
public class LoginCommand extends Abstract {

    @Override
    public void execute(Subject subject) {
        Account account = subject.getAccount();
        if(account!=null){
            System.out.println("���Ѿ���½����");
        }
        System.out.println("�������û���>>");
        String username = scanner.nextLine();
        System.out.println("����������>>");
        String password = scanner.nextLine();
        account=this.accountService.login(username,password);
        if(account!=null&&account.getAccountStatus()== AccountStatus.UNLOCK){
            System.out.println(account.getAccountType()+"��¼�ɹ�");
            subject.setAccount(account);
        }else if(account!=null&&account.getAccountStatus()!= AccountStatus.UNLOCK){
            System.out.println("�����˻��Ѿ�����ͣ���޷���½������ϵ����Ա��");
        }else{
            System.out.println("�û������������");
        }
    }
}
