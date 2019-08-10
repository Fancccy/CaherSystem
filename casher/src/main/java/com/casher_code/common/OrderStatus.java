package com.casher_code.common;

public enum OrderStatus {
    PAYING(1,"Î´Ö§¸¶"),PAY(2,"ÒÑÖ§¸¶");
    private int flg;
    private String desc;
    OrderStatus(int flg,String desc) {
        this.flg = flg;
        this.desc = desc;
    }
    public static OrderStatus valueOf(int flg) {
        for (OrderStatus orderStatus : values()) {
            if(orderStatus.flg == flg) {
                return orderStatus;
            }
        }
        throw new RuntimeException("orderStatus flg"
                + flg + "not fount!");
    }
}
