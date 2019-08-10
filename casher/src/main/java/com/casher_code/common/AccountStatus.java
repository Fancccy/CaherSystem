package com.casher_code.common;

public enum  AccountStatus {//�˻�״̬�����û�������
    UNLOCK(1,"����"),LOCK(2,"��ͣ");
    private int flg;
    private String desc;

    AccountStatus(int flg, String desc) {
        this.flg = flg;
        this.desc = desc;
    }
    public static AccountStatus valueOf(int flg) {
        for (AccountStatus accountStatus : values()) {
            if(accountStatus.flg == flg) {
                return accountStatus;    //����һ����
                                         // ����������������������Ӧ���˻�״̬  �������������õ�
            }
        }
        throw new RuntimeException("accountType flg"
                + flg + "not found!");
    }

}
