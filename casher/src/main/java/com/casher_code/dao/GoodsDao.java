package com.casher_code.dao;

import com.casher_code.entity.Account;
import com.casher_code.entity.Goods;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao extends BaseDao {
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    Goods goods=null;

    public List<Goods> query(){
        List<Goods> list = new ArrayList<>();
        try {
            connection = this.getConnection(true);
            String sql = "select * from goods";
            this.preparedStatement = connection.prepareStatement(sql);
            this.resultSet = this.preparedStatement.executeQuery();
            //返回结果集到resultSet
            if (this.resultSet != null) {
                System.out.println("开始看商品了");
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
    public Goods put(Goods good){
        int flg = 0;
        try {
            connection = this.getConnection(true);
            String sql="insert into goods(id,name,introduce,stock,unit,price,discount) value (?,?,?,?,?,?,?)";
            this.preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setInt(1,good.getId());
            preparedStatement.setString(2,good.getName());
            preparedStatement.setString(3,good.getIntroduce());
            preparedStatement.setInt(4,good.getStock());
            preparedStatement.setString(5,good.getUnit());
            preparedStatement.setInt(6,good.getPrice());
            preparedStatement.setInt(7,good.getDiscount());
            flg = preparedStatement.executeUpdate();
            if(flg!=0){
                System.out.println("上架商品成功");
            }else{
                System.out.println("上架商品失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }
    private Goods extactGoods(ResultSet resultSet) throws SQLException {
        Goods goods = new Goods();
//        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String introduce = resultSet.getString("introduce");
            int stock = resultSet.getInt("stock");//库存
            String unit = resultSet.getString("unit");
            int price = resultSet.getInt("price");
            int discount = resultSet.getInt("discount");
            goods.setId(id);
            goods.setName(name);
            goods.setPrice(price);
            goods.setIntroduce(introduce);
            goods.setStock(stock);
            goods.setUnit(unit);
            goods.setDiscount(discount);

//        }
        return goods;
    }
    public Goods queryOut(String name,int id){
        try {
            connection = this.getConnection(true);
            String sql = "select id,name,introduce,stock,unit,price,discount from goods " +
                    "where name=? and id=?";
            this.preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
            this.resultSet = this.preparedStatement.executeQuery();
            //返回结果集到resultSet
            if (this.resultSet.next()) {
                //解析resultset,拿到对应的goods
                this.goods = extactGoods(resultSet);
                return this.goods;
            }else{
                return null;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return this.goods;
    }
    public boolean SoldOut(String name,int id){
        int flg = 0;
        try {
            connection = this.getConnection(true);
            String sql="delete from goods where name=? and id=?";
            this.preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
            flg = preparedStatement.executeUpdate();
            if(flg!=0){
                return true;
            }else{
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void update(int id,String name,String groupname,String message){
        int flg = 0;
        try{
            //拿到连接
            this.connection=this.getConnection(true);
            String sql=" update goods set ?=? where id=? and name=?";
            this.preparedStatement =connection.prepareStatement(sql);
            this.preparedStatement.setString(1,groupname);
            this.preparedStatement.setString(2,message);
            this.preparedStatement.setInt(3,id);
            this.preparedStatement.setString(4,name);
            flg = preparedStatement.executeUpdate();
            if(flg!=0){

                System.out.println("信息修改成功！");
            }else{
                System.out.println("信息修改失败！");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public Goods queryOutID(int id){
        try {
            connection = this.getConnection(true);
            String sql = "select * from goods " +
                    "where  id=?";
            this.preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            this.resultSet = this.preparedStatement.executeQuery();
            //返回结果集到resultSet
            if (this.resultSet.next()) {
                //解析resultset,拿到对应的goods
                this.goods = extactGoods(resultSet);
                return this.goods;
            }else{
                return null;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return this.goods;
    }
    public boolean updateG(int id,String name,int message){
        int flg = 0;
        try{
            //拿到连接
            this.connection=this.getConnection(true);
            String sql=" update goods set stock=? where id=? and name=?";
            this.preparedStatement =connection.prepareStatement(sql);
            this.preparedStatement.setInt(1,message);
            this.preparedStatement.setInt(2,id);
            this.preparedStatement.setString(3,name);
            flg = preparedStatement.executeUpdate();
            if(flg!=0){

                return true;
            }else{
               return false;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
