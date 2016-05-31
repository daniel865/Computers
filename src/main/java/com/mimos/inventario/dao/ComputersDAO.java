package com.mimos.inventario.dao;

import com.mimos.inventario.entities.Computer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Daniel on 29/05/2016.
 */
public class ComputersDAO extends BaseDAO {

    public ComputersDAO(ConnectionFactory connectionManager) {
        super(connectionManager);
    }

    public void createComputer(Computer computer) throws Exception{
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.connect();
            statement = connection.prepareStatement("INSERT INTO COMPUTADORES(ID_COM, SERIAL_COM, MODELO_COM, " +
                    "NOMBRE_RED_COM, USUARIO_COM, FABRICANTE_COM) VALUES (COMPUTADORES_SEQ.NEXTVAL, ?, ?, ?, ?, ?)");
            statement.setString(1, computer.getSerial());
            statement.setString(2, computer.getModel());
            statement.setString(3, computer.getNetworkName());
            statement.setLong(4, computer.getIdUser());
            statement.setLong(5, computer.getIdManufacturer());
            statement.execute();
        }catch (Exception e){
            Logger.getLogger(ComputersDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error creating computer", e);
        }finally {
            try {
                if (statement != null){
                    statement.close();
                }
            }catch (SQLException ex){
                Logger.getLogger(ComputersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.close(connection);
        }
    }

    public Computer searchComputer(String serial)throws Exception{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs;
        try {
            connection = connectionManager.connect();
            statement = connection.prepareStatement("SELECT * FROM COMPUTADORES WHERE SERIAL_COM = ?");
            statement.setString(1, serial);
            rs = statement.executeQuery();
            while (rs.next()){
                return new Computer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        null, rs.getInt(6), null);
            }
        }catch (Exception e){
            Logger.getLogger(ComputersDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error searching computer", e);
        }finally {
            try {
                if(statement != null){
                    statement.close();
                }
            }catch (SQLException ex){
                Logger.getLogger(ComputersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.close(connection);
        }
        return null;
    }

    public void modifyComputer(Computer computer)throws Exception{
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.connect();
            statement = connection.prepareStatement("UPDATE COMPUTADORES SET SERIAL_COM = ?, MODELO_COM = ?," +
                    "NOMBRE_RED_COM = ?, USUARIO_COM = ?, FABRICANTE_COM = ? WHERE ID_COM = ?");
            statement.setString(1, computer.getSerial());
            statement.setString(2, computer.getModel());
            statement.setString(3, computer.getNetworkName());
            statement.setInt(4, computer.getIdUser());
            statement.setInt(5, computer.getIdManufacturer());
            statement.setInt(6, computer.getId());
            statement.execute();
        }catch (Exception e){
            Logger.getLogger(ComputersDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error modifying computer", e);
        }finally {
            try {
                if (statement != null){
                    statement.close();
                }
            }catch (SQLException ex){
                Logger.getLogger(ComputersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.close(connection);
        }
    }

    public void deleteComputer(int id)throws Exception{
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.connect();
            statement = connection.prepareStatement("DELETE FROM COMPUTADORES WHERE ID_COM = ?");
            statement.setInt(1, id);
            statement.execute();
        }catch (Exception e){
            Logger.getLogger(ComputersDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error deleting computer", e);
        }finally {
            try {
                if (statement != null){
                    statement.close();
                }
            }catch (SQLException ex){
                Logger.getLogger(ComputersDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new Exception("Error deleting computer", ex);
            }
            connectionManager.close(connection);
        }
    }

}
