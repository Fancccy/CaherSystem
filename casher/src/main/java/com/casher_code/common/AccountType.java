package com.casher_code.common;

public enum AccountType {//账号类型   管理员或者客户
    ADMIN(1,"管理员"),CUSTOM(2,"客户");
    private int flg;
    private String desc;
    AccountType(int flg,String desc) {
        this.flg = flg;
        this.desc = desc;
    }
    public static AccountType valueOf(int flg) {
        for (AccountType accountType : values()) {
            if(accountType.flg == flg) {
                return accountType;    //给定一个数   在这里面查找这个数返回相应的账户类型
            }
        }
        throw new RuntimeException("accountType flg"
                + flg + "not found!");
    }
}
