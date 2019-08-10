package com.casher_code.cmd.impl;

import com.casher_code.cmd.annotation.AdminCommand;
import com.casher_code.cmd.annotation.CommandMeta;
import com.casher_code.cmd.annotation.CustormerCommand;
import com.casher_code.cmd.annotation.EntranceCommand;
import com.casher_code.cmd.impl.account.AccountBrowseCommand;
import com.casher_code.cmd.impl.account.AccountPasswordResetCommand;
import com.casher_code.cmd.impl.account.AccountStatusSetCommand;
import com.casher_code.cmd.impl.common.AboutCommand;
import com.casher_code.cmd.impl.common.HelpCommand;
import com.casher_code.cmd.impl.common.QuitCommand;
import com.casher_code.cmd.impl.entrance.LoginCommand;
import com.casher_code.cmd.impl.entrance.RegisterCommand;
import com.casher_code.cmd.impl.goods.GoodsBrowseCommand;
import com.casher_code.cmd.impl.goods.GoodsPutAwayCommand;
import com.casher_code.cmd.impl.goods.GoodsSoldOutCommand;
import com.casher_code.cmd.impl.goods.GoodsUpdateCommand;
import com.casher_code.cmd.impl.order.OrderBrowseCommand;
import com.casher_code.cmd.impl.order.OrderPayCommand;

import java.util.*;

public class Commands {
    public static Map<String,Command> ADMIN_COMMANDS=new HashMap<>();
    public static Map<String,Command> CUSTOMER_COMMANDS=new HashMap<>();
    public static Map<String,Command> ENTRANCE_COMMANDS=new HashMap<>();
    //������е�����ļ���
    private static final Set<Command> COMMANDS=new HashSet<>();
    private static final Command CACHED_HELP_COMMANDS;
    static {  //��̬�����
        Collections.addAll(COMMANDS,
                new AccountBrowseCommand(),
                new AccountPasswordResetCommand(),
                new AccountStatusSetCommand(),
                new AboutCommand(),
                CACHED_HELP_COMMANDS= new HelpCommand(),//��HelpCommand���л���
                new QuitCommand(),
                new LoginCommand(),
                new RegisterCommand(),
                new GoodsBrowseCommand(),
                new GoodsPutAwayCommand(),
                new GoodsSoldOutCommand(),
                new GoodsUpdateCommand(),
                new OrderBrowseCommand(),
                new OrderPayCommand());
        for(Command command:COMMANDS){
            //���÷��䣬��������з��ൽ��ͬ��map
            Class<?> cls=command.getClass();
            AdminCommand adminCommand=cls.getDeclaredAnnotation(AdminCommand.class);
            CustormerCommand customerCommand=cls.getDeclaredAnnotation(CustormerCommand.class);
            EntranceCommand entranceCommand=cls.getDeclaredAnnotation(EntranceCommand.class);
            CommandMeta commandMeta=cls.getDeclaredAnnotation(CommandMeta.class);
            if(commandMeta==null){
                continue;
            }
            String commandKey=commandMeta.name();
            if(adminCommand!=null){
                ADMIN_COMMANDS.put(commandKey,command);
            }
            if(customerCommand!=null){
                CUSTOMER_COMMANDS.put(commandKey,command);
            }
            if(entranceCommand!=null){
                ENTRANCE_COMMANDS.put(commandKey,command);
            }
        }
    }

    //�õ����������
    public static Command getCachedHelpCommands() {
        return CACHED_HELP_COMMANDS;
    }
    public static Command getAdminCommand(String commandKey){
        return getCommand(commandKey,ADMIN_COMMANDS);
    }
    public static Command getCustomerCommand(String commandKey){
        return getCommand(commandKey,CUSTOMER_COMMANDS);
    }
    public static Command getEntranceCommand(String commandKey){
        return getCommand(commandKey,ENTRANCE_COMMANDS);
    }
    public static Command getCommand(String commandKey,Map<String,Command>commandMap){
        //������Ӧ��map������commandKey���õ���Ӧ��valueֵ
        return commandMap.getOrDefault(commandKey,CACHED_HELP_COMMANDS);
        //�Ҳ������ذ���������õ����

    }
}
