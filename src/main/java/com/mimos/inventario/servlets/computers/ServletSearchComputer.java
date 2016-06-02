package com.mimos.inventario.servlets.computers;

import com.mimos.inventario.dao.ComputersDAO;
import com.mimos.inventario.dao.ConnectionFactory;
import com.mimos.inventario.entities.Computer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Daniel on 29/05/2016.
 */
public class ServletSearchComputer extends javax.servlet.http.HttpServlet {

    private final static String user = "us_comp";
    private final static String password = "1234";
    private final static String url = "jdbc:oracle:thin:@db_mimos:1521:XE";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{
        ComputersDAO computersDAO = new ComputersDAO(new ConnectionFactory(user, password, url));
        String serial = request.getParameter("serial");
        Computer computer;
        try {
            computer = computersDAO.searchComputer(serial);
            request.setAttribute("message", "El Computador fue encontrado");
            request.setAttribute("id", computer.getId());
            request.setAttribute("serial", computer.getSerial());
            request.setAttribute("model", computer.getModel());
            request.setAttribute("networkName", computer.getNetworkName());
            request.setAttribute("idUser", computer.getIdUser());
            request.setAttribute("userName", computer.getUserName());
            request.setAttribute("idManufacturer", computer.getIdManufacturer());
            request.setAttribute("nameManufacturer", computer.getNameManufacturer());
        }catch (Exception e){
            Logger.getLogger(ServletSearchComputer.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", "El Computador no fue encontrado");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{

    }

}
