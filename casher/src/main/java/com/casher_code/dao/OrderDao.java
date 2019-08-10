package com.casher_code.dao;

import com.casher_code.common.OrderStatus;
import com.casher_code.entity.Account;
import com.casher_code.entity.Order;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao extends BaseDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Order order = null;

    public List<Order> query(Account account) {
        List<Order> list = new ArrayList<>();
        try {
            connection = this.getConnection(true);
            String sql = "select * from orderr where account_id=? and account_name=?";
            this.preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setString(2, account.getName());
            this.resultSet = this.preparedStatement.executeQuery();
            //返回结果集到resultSet
            if (this.resultSet != null) {
                //解析resultset,拿到对应的goods
                while (resultSet.next()) {
                    list.add(extactOrder(resultSet));
                }
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Order extactOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getString("id"));
        order.setAccount_id(resultSet.getInt("account_id"));
        order.setAccount_name(resultSet.getString("account_name"));
        order.setActual_amount(resultSet.getInt("actual_amount"));
        order.setCreate_time(resultSet.getTimestamp("create_time").toLocalDateTime());
        order.setFinish_time(resultSet.getTimestamp("finish_time").toLocalDateTime());
        order.setOrder_status(OrderStatus.valueOf(resultSet.getInt("order_status")));
        order.setTotal_money(resultSet.getInt("total_money"));
        return order;
    }

    public Order queryOutID(Account account){
        try {
            connection = this.getConnection(true);
            String sql = " select * from orderr where  account_id = ? and account_name=?";
            this.preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,account.getId());
            preparedStatement.setString(2,account.getName());
            this.resultSet = this.preparedStatement.executeQuery();
            //返回结果集到resultSet
            if (this.resultSet.next()) {
                //解析resultset,拿到对应的goods
                this.order = extactOrder(resultSet);
                return this.order;
            }else{
                return null;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return this.order;
    }
    public Order insert(Account account, int actual_amount, int total_money,String id) {
        int flg = 0;
        try {
            connection = this.getConnection(true);
            String sql = "insert into orderr (id,account_id,account_name,create_time,finish_time,actual_amount,total_money,order_status) values (?,?,?,?,?,?,?,?)";
            this.preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.setInt(2, account.getId());
            preparedStatement.setString(3, account.getName());
            preparedStatement.setTimestamp(4,  new java.sql.Timestamp(new Date().getTime()));
            preparedStatement.setTimestamp(5, new java.sql.Timestamp(new Date().getTime()));
            preparedStatement.setInt(6, actual_amount);
            preparedStatement.setInt(7, total_money);
            preparedStatement.setInt(8, 1);
            flg = preparedStatement.executeUpdate();
            if (flg != 0) {
                return queryOutID(account);
            } else {
                return order;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
    public boolean update(Account account,int i,java.sql.Timestamp a){
        int flg=0,flg1=0;
        try {
            connection = this.getConnection(true);
            String sql = " update  orderr  set  order_status = ? ,finish_time=? where account_id=? and account_name=?";
            this.preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,i);
            preparedStatement.setTimestamp(2,a);
            preparedStatement.setInt(3,account.getId());
            preparedStatement.setString(4,account.getName());
            flg = this.preparedStatement.executeUpdate();
            //返回结果集到resultSet
            if (flg!=0) {
                //解析resultset,拿到对应的goods
                return true;
            }else{
                return false;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateT(Account account,double count,double rcount){
        int flg=0;
        try {
            connection = this.getConnection(true);
            String sql = " update  orderr  set  actual_amount = ?  , total_money = ? where account_id=? and account_name=?";
            this.preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1,rcount);
            preparedStatement.setDouble(2,count);
            preparedStatement.setString(4,account.getName());
            preparedStatement.setInt(3,account.getId());
            flg= this.preparedStatement.executeUpdate();
            //返回结果集到resultSet
            if (flg!=0) {
                //解析resultset,拿到对应的goods
                return true;
            }else{
                return false;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Order queryOut(String id){
        try {
            connection = this.getConnection(true);
            String sql = " select * from orderr where  id=?";
            this.preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            this.resultSet = this.preparedStatement.executeQuery();
            //返回结果集到resultSet
            if (this.resultSet.next()) {
                //解析resultset,拿到对应的goods
                this.order = extactOrder(resultSet);
                return this.order;
            }else{
                return null;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return this.order;
    }
}
