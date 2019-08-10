package com.casher_code.entity;

import com.casher_code.common.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private String id;
    private Integer account_id;
    private String account_name;
    private LocalDateTime create_time;
    private LocalDateTime finish_time;
    private Integer actual_amount;
    private Integer total_money;
    private OrderStatus order_status;
}
