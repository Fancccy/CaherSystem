package com.casher_code.entity;

import lombok.Data;

@Data
public class Goods {
    private Integer id;
    private String name;
    private String introduce;
    private Integer stock;  //�洢��λ
    private String unit;  //���
    private Integer price;
    private Integer discount;
}
