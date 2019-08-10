package com.casher_code.cmd.impl.account;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Account;

@CommandMeta(
        name = "MMCZ",
        desc = "密码重置",
        group = "账户信息"
)
@AdminCommand
public class AccountPasswordResetCommand extends Abstract {

    @Override
    public void execute(Subject subject) {
        System.out.println("请输入您要重置密码的账户名：");
        String username = scanner.nextLine();
        System.out.println("请输入与账户名相应的账户ID：");
        String id = scanner.nextLine();
        Account account = this.accountService.query(username,id);
        if(account==null){
            System.out.println("您输入的账户不存在，请重新输入！");
            execute(subject);
        }
        System.out.println("请输入您要重置的密码：");
        String password = scanner.nextLine();
        if(password.trim()==null){
            System.out.println("密码不能为空！请重新输入:");
            password = scanner.nextLine().trim();
        }
        System.out.println("请再次确认密码：");
        String password1 = scanner.nextLine();
        if(password.equals(password1)){
           this.accountService.update(username,id,password);
        }else{
            System.out.println("您两次输入的密码不一致，请重新输入！");
            execute(subject);
        }

    }//账户密码重置
}
