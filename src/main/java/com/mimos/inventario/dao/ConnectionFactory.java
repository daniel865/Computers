package com.mimos.inventario.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Daniel on 29/05/2016.
 */
public class ConnectionFactory {

    String user;
    String password;
    String url;

    public ConnectionFactory(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public Connection connect() throws Exception{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            throw new Exception("Error to connect", e);
        }
    }

    public void close(Connection connection)throws Exception{
        try {
            if ( connection != null && !connection.isClosed() ){
                connection.close();
            }
        }catch (Exception e){
            System.out.println("Error to close connection");
        }
    }

}
