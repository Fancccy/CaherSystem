package com.casher_code.entity;

import lombok.Data;

@Data
public class Goods {
    private Integer id;
    private String name;
    private String introduce;
    private Integer stock;  //´æ´¢µ¥Î»
    private String unit;  //¿â´æ
    private Integer price;
    private Integer discount;
}
