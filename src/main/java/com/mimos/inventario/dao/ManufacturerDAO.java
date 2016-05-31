package com.mimos.inventario.dao;

import com.mimos.inventario.entities.Manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ASUS on 31/05/2016.
 */
public class ManufacturerDAO extends BaseDAO {

    public ManufacturerDAO(ConnectionFactory connectionManager) {
        super(connectionManager);
    }

    public List<Manufacturer> loadManufacturers()throws Exception{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs;
        List<Manufacturer> manufacturerList = new ArrayList<Manufacturer>();
        try {
            connection = connectionManager.connect();
            statement = connection.prepareStatement("SELECT * FROM FABRICANTES");
            rs = statement.executeQuery();
            while (rs.next()){
                manufacturerList.add(new Manufacturer(rs.getInt(1), rs.getString(2)));
            }
            return manufacturerList;
        }catch (Exception e){
            Logger.getLogger(ManufacturerDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error loading computers", e);
        }finally {
            try {
                if(statement != null){
                    statement.close();
                }
            }catch (SQLException ex){
                Logger.getLogger(ManufacturerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.close(connection);
        }

    }

}
