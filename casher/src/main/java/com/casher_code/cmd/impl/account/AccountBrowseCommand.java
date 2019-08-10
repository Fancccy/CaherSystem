package com.casher_code.cmd.impl.account;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.CustormerCommand;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Account;

@CommandMeta(
        name = "CKZH",
        desc = "查看账户",
        group = "账户信息"
)
@AdminCommand
public class AccountBrowseCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        System.out.println("请输入您要查看的账户名：");
        String username = scanner.nextLine();
        System.out.println("请输入您要查看用户的ID");
        String userId = scanner.nextLine();
        Account account = this.accountService.query(username,userId);
        if(account!=null) {
            System.out.println("***********************");
            System.out.println("用户ID：" + account.getId());
            System.out.println("用户名：" + account.getUsername());
            System.out.println("用户姓名：" + account.getName());
            System.out.println("用户状态：" + account.getAccountStatus());
            System.out.println("用户类型：" + account.getAccountType());
            System.out.println("用户密码：" + account.getPassword());
            System.out.println("************************");
        }else{
            System.out.println("Sorry!this account is not existed");
        }
    }//账户信息浏览
}
