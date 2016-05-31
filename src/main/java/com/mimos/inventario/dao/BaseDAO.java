package com.mimos.inventario.dao;

/**
 * Created by Daniel on 29/05/2016.
 */
public class BaseDAO {

    protected ConnectionFactory connectionManager;

    public BaseDAO(ConnectionFactory connectionManager) {
        this.connectionManager = connectionManager;
    }

}
