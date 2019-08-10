package com.casher_code.cmd.impl.entrance;

import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.EntranceCommand;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Account;

@CommandMeta(
        name = "ZC",
        desc = "注册",
        group = "入口命令"
)
@EntranceCommand
public class RegisterCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        Account account= new Account();
        System.out.println("请输入您的用户账号>>");
        String username = scanner.nextLine();
        System.out.println("请输入您的姓名>>");
        String name = scanner.nextLine();
        System.out.println("请设置您的密码>>");
        String password1 = scanner.nextLine();
        System.out.println("请再次确认您的密码>>");
        String password2 = scanner.nextLine();
        if(password1.equals(password2)){
            account = this.accountService.regist(username,password1,name);
        }else{
            System.out.println("两次密码输入不一致，请重新输入");
            execute(subject);
        }
        subject.setAccount(account);
    }

}
