package com.casher_code.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    private static volatile DataSource dataSource;

    //���û���ʵ��
    private DataSource getDataSource() {
        if (dataSource == null) {
            synchronized(DataSource.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();//MySql����Դ
                    String host = "127.0.0.1";
                    String port = "3306";
                    ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://" + (host + ":" + port) + "/check_stand?useSSL=false");
                    ((MysqlDataSource) dataSource).setUser("root");
                    ((MysqlDataSource) dataSource).setPassword("612425");
                }
            }
        }
        return dataSource;
    }

    protected Connection getConnection(boolean autoCommit) throws SQLException {
        //��ȡ����
        Connection connection = this.getDataSource().getConnection();
        //���true  ÿдһ����� �Զ������ύ
        connection.setAutoCommit(autoCommit);
        return connection;
    }

    protected void closeResource(ResultSet resultSet, PreparedStatement statement, Connection connection) {
        //��� -> ���� -> ����
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
