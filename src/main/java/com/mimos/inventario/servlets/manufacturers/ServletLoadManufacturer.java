package com.mimos.inventario.servlets.manufacturers;

import com.mimos.inventario.dao.ComputersDAO;
import com.mimos.inventario.dao.ConnectionFactory;
import com.mimos.inventario.dao.ManufacturerDAO;
import com.mimos.inventario.entities.Manufacturer;
import com.mimos.inventario.servlets.computers.ServletLoadComputers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ASUS on 31/05/2016.
 */
public class ServletLoadManufacturer extends javax.servlet.http.HttpServlet {

    private final static String user = "us_comp";
    private final static String password = "1234";
    private final static String url = "jdbc:oracle:thin:@localhost:1521:XE";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{
        ManufacturerDAO manufacturerDAO = new ManufacturerDAO(new ConnectionFactory(user, password, url));
        List<Manufacturer> manufacturerList;
        try {
            manufacturerList = manufacturerDAO.loadManufacturers();
            request.setAttribute("manufacturerList", manufacturerList);
        }catch (Exception e){
            Logger.getLogger(ServletLoadManufacturer.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", "Error al cargar los fabricantes");
        }
    }

}
