package com.mimos.inventario.servlets.computers;

import com.mimos.inventario.dao.ComputersDAO;
import com.mimos.inventario.dao.ConnectionFactory;
import com.mimos.inventario.dao.ManufacturerDAO;
import com.mimos.inventario.dao.UserDAO;
import com.mimos.inventario.entities.Computer;
import com.mimos.inventario.entities.Manufacturer;
import com.mimos.inventario.entities.User;

import java.io.IOException;
import java.util.List;
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
        ManufacturerDAO manufacturerDAO = new ManufacturerDAO(new ConnectionFactory(user, password, url));
        UserDAO userDAO = new UserDAO(new ConnectionFactory(user, password, url));
        String serial = request.getParameter("serial");
        Computer computer;
        List<Manufacturer> manufacturerList;
        List<User> userList;
        try {
            computer = computersDAO.searchComputer(serial);
            manufacturerList = manufacturerDAO.loadManufacturers();
            userList = userDAO.loadUsers();
            request.setAttribute("message", "El Computador fue encontrado");
            request.setAttribute("id", String.valueOf(computer.getId()));
            request.setAttribute("serial", computer.getSerial());
            request.setAttribute("model", computer.getModel());
            request.setAttribute("networkName", computer.getNetworkName());
            request.setAttribute("idUser", String.valueOf(computer.getIdUser()));
            request.setAttribute("userName", computer.getUserName());
            request.setAttribute("idManufacturer", String.valueOf(computer.getIdManufacturer()));
            request.setAttribute("nameManufacturer", computer.getNameManufacturer());
            request.setAttribute("manufacturerList", manufacturerList);
            request.setAttribute("userList", userList);
        }catch (Exception e){
            Logger.getLogger(ServletSearchComputer.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", "El Computador no fue encontrado");
        }
        request.getRequestDispatcher("editComputer.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{
        doPost(request, response);
    }

}
