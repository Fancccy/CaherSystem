package com.casher_code.cmd.impl.common;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.CustormerCommand;
import com.casher_code.cmd.annotation.EntranceCommand;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;

@CommandMeta(
        name = "TCXT",
        desc = "退出系统",
        group = "公共命令"
)
@AdminCommand
@CustormerCommand
@EntranceCommand
public class QuitCommand extends Abstract {

    @Override
    public void execute(Subject subject) {
        System.out.println("**********BYE**********");
        System.out.println("****create by jia******");
        System.out.println("******2019-8-4*********");
        System.out.println("***********************");
        scanner.close();
        System.exit(0);
    }
}
