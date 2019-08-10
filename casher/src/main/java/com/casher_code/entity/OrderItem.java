package com.casher_code.entity;

import lombok.Data;

@Data
public class OrderItem {
    private Integer id;
    private String orderId;   //¶©µ¥±àºÅ
    private Integer goodsId;
    private String goodsName;
    private String goodsIntroduce;
    private Integer goodsNum;
    private String goodsUnit;
    private Integer goodsPrice;
    private Integer goodsDiscount;
}
