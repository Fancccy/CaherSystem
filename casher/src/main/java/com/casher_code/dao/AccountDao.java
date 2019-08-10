package com.casher_code.dao;

import com.casher_code.cmd.impl.Abstract;
import com.casher_code.cmd.impl.Subject;
import com.casher_code.common.AccountStatus;
import com.casher_code.common.AccountType;
import com.casher_code.entity.Account;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao extends BaseDao {
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    Account account=null;


    public Account login(String username,String password){

        try{
            //拿到连接
            this.connection=this.getConnection(true);
            String sql="select id,username,password,name,account_type,account_status " +
                    "from account where username=?and password=?";
            this.preparedStatement =connection.prepareStatement(sql);
            this.preparedStatement.setString(1,username);
            this.preparedStatement.setString(2, DigestUtils.md5Hex(password));
            this.resultSet=this.preparedStatement.executeQuery();
            //返回结果集到resultSet
            if(this.resultSet.next()){
                //解析resultset,拿到对应的account
                this.account= this.extractAccount(resultSet);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return this.account;
    }
    private Account extractAccount(ResultSet resultSet) throws SQLException {
        Account account=new Account();
        account.setId(resultSet.getInt("id"));
        account.setUsername(resultSet.getString("username"));
        account.setPassword(resultSet.getString("password"));
        account.setName(resultSet.getString("name"));
        account.setAccountType(AccountType.valueOf(resultSet.getInt("account_type")));
        account.setAccountStatus(AccountStatus.valueOf(resultSet.getInt("account_status")));

        return account;

    }
    public Account regist(String username,String password,String name){
        int flg = 0;
        try{
            //拿到连接
            connection=this.getConnection(true);
            String sql="insert into account (username,password,name,account_type) value (?,?,?,2)";
            preparedStatement = this.connection.prepareStatement(sql);
            this.preparedStatement.setString(1,username);
            this.preparedStatement.setString(2, DigestUtils.md5Hex(password));
            this.preparedStatement.setString(3,name);
            flg = preparedStatement.executeUpdate();
            if(flg!=0){
                account = this.login(username,password);
                System.out.println("恭喜您！注册成功");
            }else{
                System.out.println("注册失败");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return account;
    }
    public Account query(String username,String userID){
        try{
            //拿到连接
            this.connection=this.getConnection(true);
            String sql="select id,username,password,name,account_type,account_status " +
                    "from account where username=? and id=?";
            this.preparedStatement =connection.prepareStatement(sql);
            this.preparedStatement.setString(1,username);
            this.preparedStatement.setString(2,userID);
            this.resultSet=this.preparedStatement.executeQuery();
            if(resultSet==null){
                return null;
            }
            //返回结果集到resultSet
            else if(this.resultSet.next()){
                //解析resultset,拿到对应的account
                this.account= this.extractAccount(resultSet);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return this.account;
    }
    public Account update(String username,String id,String password){
        int flg = 0;
        try{
            //拿到连接
            this.connection=this.getConnection(true);
            String sql=" update account set password=? where id=? and username=?";
            this.preparedStatement =connection.prepareStatement(sql);
            this.preparedStatement.setString(1,DigestUtils.md5Hex(password));
            this.preparedStatement.setString(2,id);
            this.preparedStatement.setString(3,username);
            flg = preparedStatement.executeUpdate();
            if(flg!=0){
                account = this.login(username,password);
                System.out.println("重置密码成功！");
            }else{
                System.out.println("重置密码失败！");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return this.account;
    }
    public Account updateStatus(String username,String id){
        int flg = 0;
        try{
            //拿到连接
            this.connection=this.getConnection(true);
            String sql=" update account set account_status=2 where id=? and username=?";
            this.preparedStatement =connection.prepareStatement(sql);
            this.preparedStatement.setString(1,id);
            this.preparedStatement.setString(2,username);
            flg = preparedStatement.executeUpdate();
            if(flg!=0){

                System.out.println("账户启停成功！");
            }else{
                System.out.println("账户启停失败！");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return this.account;
    }

}
