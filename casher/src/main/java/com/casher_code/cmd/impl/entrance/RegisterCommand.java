package com.casher_code.cmd.impl.entrance;

import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.EntranceCommand;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Account;

@CommandMeta(
        name = "ZC",
        desc = "ע��",
        group = "�������"
)
@EntranceCommand
public class RegisterCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        Account account= new Account();
        System.out.println("�����������û��˺�>>");
        String username = scanner.nextLine();
        System.out.println("��������������>>");
        String name = scanner.nextLine();
        System.out.println("��������������>>");
        String password1 = scanner.nextLine();
        System.out.println("���ٴ�ȷ����������>>");
        String password2 = scanner.nextLine();
        if(password1.equals(password2)){
            account = this.accountService.regist(username,password1,name);
        }else{
            System.out.println("�����������벻һ�£�����������");
            execute(subject);
        }
        subject.setAccount(account);
    }

}
