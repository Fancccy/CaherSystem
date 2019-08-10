package com.casher_code.cmd.impl.common;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.CustormerCommand;
import com.casher_code.cmd.annotation.EntranceCommand;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;

@CommandMeta(
        name = "GYXT",
        desc = "关于系统",
        group = "公共命令"
)
@AdminCommand
@CustormerCommand
@EntranceCommand
//关于系统的描述
public class AboutCommand extends Abstract {

    @Override
    public void execute(Subject subject) {
        System.out.println("AboutCommand");
        System.out.println("*******************************");
        System.out.println("******* create by jia***********");
        System.out.println("*******A System for pay********");
        System.out.println("*******************************");
    }
}
