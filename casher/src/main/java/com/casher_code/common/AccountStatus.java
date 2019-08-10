package com.casher_code.common;

public enum  AccountStatus {//账户状态是启用还是锁定
    UNLOCK(1,"启用"),LOCK(2,"启停");
    private int flg;
    private String desc;

    AccountStatus(int flg, String desc) {
        this.flg = flg;
        this.desc = desc;
    }
    public static AccountStatus valueOf(int flg) {
        for (AccountStatus accountStatus : values()) {
            if(accountStatus.flg == flg) {
                return accountStatus;    //给定一个数
                                         // 在这里面查找这个数返回相应的账户状态  是锁定还是启用的
            }
        }
        throw new RuntimeException("accountType flg"
                + flg + "not found!");
    }

}
