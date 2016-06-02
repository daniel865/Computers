package com.mimos.inventario.servlets.computers;

import com.mimos.inventario.dao.ComputersDAO;
import com.mimos.inventario.dao.ConnectionFactory;
import com.mimos.inventario.dao.ManufacturerDAO;
import com.mimos.inventario.entities.Computer;
import com.mimos.inventario.entities.Manufacturer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ASUS on 31/05/2016.
 */
public class ServletLoadComputers extends javax.servlet.http.HttpServlet {

    private final static String user = "us_comp";
    private final static String password = "1234";
    private final static String url = "jdbc:oracle:thin:@db_mimos:1521:XE";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{
        ComputersDAO computersDAO = new ComputersDAO(new ConnectionFactory(user, password, url));
        List<Computer> computerList;
        try {
            computerList = computersDAO.loadComputers();
            request.setAttribute("computerList", computerList);
        }catch (Exception e){
            Logger.getLogger(ServletLoadComputers.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", "Error al cargar los computadores");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
