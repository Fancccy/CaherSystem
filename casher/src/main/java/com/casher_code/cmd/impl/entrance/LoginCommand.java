package com.casher_code.cmd.impl.entrance;

import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.EntranceCommand;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.common.AccountStatus;
import com.casher_code.entity.Account;

import java.sql.SQLOutput;

@CommandMeta(name="DL",desc="登录",group="入口命令")
@EntranceCommand
public class LoginCommand extends Abstract {

    @Override
    public void execute(Subject subject) {
        Account account = subject.getAccount();
        if(account!=null){
            System.out.println("您已经登陆过了");
        }
        System.out.println("请输入用户名>>");
        String username = scanner.nextLine();
        System.out.println("请输入密码>>");
        String password = scanner.nextLine();
        account=this.accountService.login(username,password);
        if(account!=null&&account.getAccountStatus()== AccountStatus.UNLOCK){
            System.out.println(account.getAccountType()+"登录成功");
            subject.setAccount(account);
        }else if(account!=null&&account.getAccountStatus()!= AccountStatus.UNLOCK){
            System.out.println("您的账户已经被启停，无法登陆，请联系管理员！");
        }else{
            System.out.println("用户名或密码错误");
        }
    }
}
