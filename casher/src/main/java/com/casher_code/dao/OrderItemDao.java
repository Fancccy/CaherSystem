package com.casher_code.dao;

import com.casher_code.entity.Account;
import com.casher_code.entity.Goods;
import com.casher_code.entity.Order;
import com.casher_code.entity.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDao extends BaseDao{
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    OrderItem orderItem=null;
    public OrderItem put(Goods good,Order order,int goods_num){
        int flg = 0;
        try {
            connection = this.getConnection(true);
            String sql="insert into order_item (order_id,goods_id,goods_name,goods_introduce,goods_num,goods_unit,goods_price,goods_discount) value (?,?,?,?,?,?,?,?)";
            this.preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,order.getId());
            preparedStatement.setInt(2,good.getId());
            preparedStatement.setString(3,good.getName());
            preparedStatement.setString(4,good.getIntroduce());
            preparedStatement.setInt(5,goods_num);
            preparedStatement.setString(6,good.getUnit());
            preparedStatement.setInt(7,good.getPrice());
            preparedStatement.setInt(8,good.getDiscount());
            flg = preparedStatement.executeUpdate();
            if(flg!=0){
                System.out.println(good.getName()+"下单成功");
            }else{
                System.out.println(good.getName()+"下单失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItem;
    }
    public List<OrderItem> query(Order order){
        List<OrderItem> list = new ArrayList<>();
        try {
            connection = this.getConnection(true);
            String sql = "select * from order_item where order_id=?";
            this.preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,order.getId());
            this.resultSet = this.preparedStatement.executeQuery();
            //返回结果集到resultSet
            if (this.resultSet != null) {
                //解析resultset,拿到对应的goods
                while (resultSet.next()) {
                    list.add(extactGoods(resultSet));
                }
                return list;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private OrderItem extactGoods(ResultSet resultSet) throws SQLException {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(resultSet.getInt("id"));
        orderItem.setOrderId(resultSet.getString("order_id"));
        orderItem.setGoodsId(resultSet.getInt("goods_id"));
        orderItem.setGoodsName(resultSet.getString("goods_name"));//库存
        orderItem.setGoodsIntroduce(resultSet.getString("goods_introduce"));
        orderItem.setGoodsNum(resultSet.getInt("goods_num"));
        orderItem.setGoodsUnit( resultSet.getString("goods_unit"));
        orderItem.setGoodsPrice( resultSet.getInt("goods_price"));
        orderItem.setGoodsDiscount( resultSet.getInt("goods_discount"));
        return orderItem;
    }
}
