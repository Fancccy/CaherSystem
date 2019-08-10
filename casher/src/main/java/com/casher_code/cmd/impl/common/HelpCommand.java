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
        desc = "����ϵͳ",
        group = "��������"
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
    //Map.values()��������value�ļ���
    public void entranceHelp(){
        print("��ӭ", Commands.ENTRANCE_COMMANDS.values());
    }
    public void customerHelp(){
        print("�ͻ���", Commands.CUSTOMER_COMMANDS.values());
    }
    public void adminHelp(){
        print("�����", Commands.ADMIN_COMMANDS.values());
    }
    //ͨ�õĴ�ӡ����
    public void print(String title, Collection<Command> collection){
        System.out.println("********"+title+"*********");
        Map<String, List<String>> helpInfo=new HashMap<>();

        for(Command command:collection){
            CommandMeta commandMeta=command.getClass().getDeclaredAnnotation(CommandMeta.class);
            String group=commandMeta.group();  //�õ���map��key

            List<String> func=helpInfo.get(group);   //��ʼû��group��Ϊ��
            if(func==null){
                func=new ArrayList<>();
                helpInfo.put(group,func);
            }
            func.add(commandMeta.desc()+"("+commandMeta.name()+")");
        }
        //entrySetȡ����ֵ�Եļ���
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
        System.out.println("����˵����ź���ı��(���Դ�Сд����������һ������");
        System.out.println("************************************************");
    }
}
