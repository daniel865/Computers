package com.mimos.inventario.servlets.computers;

import com.mimos.inventario.dao.ComputersDAO;
import com.mimos.inventario.dao.ConnectionFactory;
import com.mimos.inventario.entities.Computer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Daniel on 30/05/2016.
 */
public class ServletUpdateComputer extends javax.servlet.http.HttpServlet {

    private final static String user = "us_comp";
    private final static String password = "1234";
    private final static String url = "jdbc:oracle:thin:@db_mimos:1521:XE";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{
        ComputersDAO computersDAO = new ComputersDAO(new ConnectionFactory(user, password, url));
        Integer id = Integer.parseInt(request.getParameter("id"));
        String serial = request.getParameter("serial");
        String model = request.getParameter("model");
        String networkName = request.getParameter("networkName");
        Integer idUser = Integer.parseInt(request.getParameter("idUser"));
        String userName = request.getParameter("userName");
        Integer idManufacturer = Integer.parseInt(request.getParameter("idManufacturer"));
        String nameManufacturer = request.getParameter("nameManufacturer");
        try {
            computersDAO.modifyComputer(new Computer(id, serial, model, networkName,
                    idUser, userName, idManufacturer, nameManufacturer));
        }catch (Exception e){
            Logger.getLogger(ServletCreateComputer.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", e.getMessage());
            request.setAttribute("id", id);
            request.setAttribute("serial", serial);
            request.setAttribute("model", model );
            request.setAttribute("networkName", networkName);
            request.setAttribute("idUser", idUser);
            request.setAttribute("userName", userName);
            request.setAttribute("idManufacturer", idManufacturer);
            request.setAttribute("nameManufacturer", nameManufacturer);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{

    }

}
