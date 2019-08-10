package com.casher_code.common;

public enum AccountType {//�˺�����   ����Ա���߿ͻ�
    ADMIN(1,"����Ա"),CUSTOM(2,"�ͻ�");
    private int flg;
    private String desc;
    AccountType(int flg,String desc) {
        this.flg = flg;
        this.desc = desc;
    }
    public static AccountType valueOf(int flg) {
        for (AccountType accountType : values()) {
            if(accountType.flg == flg) {
                return accountType;    //����һ����   ����������������������Ӧ���˻�����
            }
        }
        throw new RuntimeException("accountType flg"
                + flg + "not found!");
    }
}
