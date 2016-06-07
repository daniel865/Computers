package com.mimos.inventario.dao;

import com.mimos.inventario.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ASUS on 07/06/2016.
 */
public class UserDAO extends BaseDAO {

    public UserDAO(ConnectionFactory connectionManager) {
        super(connectionManager);
    }


    public List<User> loadUsers() throws Exception{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs;
        List<User> userList = new ArrayList<User>();
        try {
            connection = connectionManager.connect();
            statement = connection.prepareStatement("SELECT * FROM USUARIOS");
            rs = statement.executeQuery();
            while (rs.next()){
                userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7), rs.getInt(8)));
            }
            return userList;
        }catch (Exception e){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error loading users");
        }finally {
            try {
                if (statement != null){
                    statement.close();
                }
            }catch (SQLException e){
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            }
            connectionManager.close(connection);
        }
    }

}
