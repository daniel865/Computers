package com.mimos.inventario.servlets.computers;

import com.mimos.inventario.dao.ComputersDAO;
import com.mimos.inventario.dao.ConnectionFactory;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Daniel on 30/05/2016.
 */
public class ServletDeleteComputer extends javax.servlet.http.HttpServlet{

    private final static String user = "us_comp";
    private final static String password = "1234";
    private final static String url = "jdbc:oracle:thin:@localhost:1521:XE";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{
        ComputersDAO computersDAO = new ComputersDAO(new ConnectionFactory(user, password, url));
        Integer id = Integer.parseInt(request.getParameter("id"));
        try {
            computersDAO.deleteComputer(id);
            request.setAttribute("message", "Computador eliminado correctamente");
        }catch (Exception e){
            Logger.getLogger(ServletDeleteComputer.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", "Error al eliminar el computador");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{

    }

}
