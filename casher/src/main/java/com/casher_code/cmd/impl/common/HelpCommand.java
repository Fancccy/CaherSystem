package com.casher_code.cmd.impl.common;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.CustormerCommand;
import com.casher_code.cmd.annotation.EntranceCommand;
import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Command;
import com.casher_code.cmd.impl.Commands;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.entity.Account;

import java.util.*;

@CommandMeta(
        name = "BZXT",
        desc = "帮助系统",
        group = "公共命令"
)
@AdminCommand
@CustormerCommand
@EntranceCommand
public class HelpCommand extends Abstract {
    public void execute(Subject subject) {
        System.out.println("HelpCommand");
        Account account=subject.getAccount();
        if(account==null){
            entranceHelp();
        }else{
            switch(account.getAccountType()){
                case CUSTOM:
                    customerHelp();
                    break;
                case ADMIN:
                    adminHelp();
                    break;
                default:
            }
        }
    }
    //Map.values()返回所有value的集合
    public void entranceHelp(){
        print("欢迎", Commands.ENTRANCE_COMMANDS.values());
    }
    public void customerHelp(){
        print("客户端", Commands.CUSTOMER_COMMANDS.values());
    }
    public void adminHelp(){
        print("管理端", Commands.ADMIN_COMMANDS.values());
    }
    //通用的打印命令
    public void print(String title, Collection<Command> collection){
        System.out.println("********"+title+"*********");
        Map<String, List<String>> helpInfo=new HashMap<>();

        for(Command command:collection){
            CommandMeta commandMeta=command.getClass().getDeclaredAnnotation(CommandMeta.class);
            String group=commandMeta.group();  //拿到新map的key

            List<String> func=helpInfo.get(group);   //开始没有group，为空
            if(func==null){
                func=new ArrayList<>();
                helpInfo.put(group,func);
            }
            func.add(commandMeta.desc()+"("+commandMeta.name()+")");
        }
        //entrySet取出键值对的集合
        int i=0;
        for(Map.Entry<String,List<String>> entry:helpInfo.entrySet()){

            i++;
            System.out.println(i+"."+entry.getKey());
            int j=0;
            for(String item:entry.getValue()){
                j++;
                System.out.println("\t"+(i)+"."+(j)+" "+item);
            }
        }
        System.out.println("输入菜单括号后面的编号(忽略大小写），进行下一步操作");
        System.out.println("************************************************");
    }
}
