package com.casher_code.cmd.impl.account;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.common.AccountStatus;
import com.casher_code.entity.Account;

@CommandMeta(
        name = "QTZH",
        desc = "启停账户",
        group = "账户信息"
)
@AdminCommand
public class AccountStatusSetCommand extends Abstract {
    @Override
    public void execute(Subject subject) {
        System.out.println("请输入您要启停的账户：");
        String username = scanner.nextLine();
        System.out.println("请输入您要启停的账户ID");
        String id = scanner.nextLine();
        Account account = this.accountService.query(username,id);
        if(account==null){
            System.out.println("此用户不存在，请重新输入用户信息！");
            execute(subject);
        }else{
            if(account.getAccountStatus()==AccountStatus.LOCK ){
                System.out.println("此账户已经启停");
            }
            this.accountService.updateStatus(username,id);
        }
    }//账户状态设置
}
