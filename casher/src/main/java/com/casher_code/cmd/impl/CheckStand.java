package com.casher_code.cmd.impl;

import com.casher_code.entity.Account;

public class CheckStand extends Abstract {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new CheckStand().execute(subject);
    }
    @Override
    public void execute(Subject subject) {
        Commands.getCachedHelpCommands().execute(subject);
        while(true){
            System.out.println(">>>");
            String str=scanner.nextLine();
            String commandCode=str.trim().toUpperCase();
            Account account=subject.getAccount();
            if(account==null){
                Commands.getEntranceCommand(commandCode).execute(subject);
            }else{
                switch(account.getAccountType()){
                    case ADMIN:
                        Commands.getAdminCommand(commandCode).execute(subject);
                        break;
                    case CUSTOM:
                        Commands.getCustomerCommand(commandCode).execute(subject);
                        break;
                    default:
                }
            }
        }
    }
}
