<%@ page import="java.util.List" %>
<%@ page import="com.mimos.inventario.entities.Computer" %><%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 28/05/2016
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String message = request.getAttribute("message") != null ? (String) request.getAttribute("message") : null;
    String id = request.getAttribute("id") != null ? (String) request.getAttribute("id") : null;
    String serial = request.getAttribute("serial") != null ? (String) request.getAttribute("serial") : null;
    String model = request.getAttribute("model") != null ? (String) request.getAttribute("model") : null;
    String networkName = request.getAttribute("networkName") != null ? (String) request.getAttribute("networkName") : null;
    String idUser = request.getAttribute("idUser") != null ? (String) request.getAttribute("idUser") : null;
    String userName = request.getAttribute("userName") != null ? (String) request.getAttribute("userName") : null;
    String idManufacturer = request.getAttribute("idManufacturer") != null ? (String) request.getAttribute("idManufacturer") : null;
    String nameManufacturer = request.getAttribute("nameManufacturer") != null ? (String) request.getAttribute("nameManufacturer") : null;
    List<Computer> computerList = request.getAttribute("computerList") != null ? (List<Computer>) request.getAttribute("computerList") : null;
%>
  <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Inventario MIMO'S</title>
      <link rel="stylesheet" href="css/bootstrap.min.css" />
      <link rel="stylesheet" href="css/index.css" />
  </head>
  <body>

  <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
          <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="<%=request.getContextPath()%>/loadComputers.do">Inventario mimos</a>
          </div>
      </div>
  </nav>

  <div class="container-fluid" id="content">
      <div class="row">
          <div class="col-sm-3 col-md-2 sidebar">
              <ul class="nav nav-sidebar">
                  <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
                  <li><a href="#">Placas Madres</a></li>
                  <li><a href="#">Procesadores</a></li>
                  <li><a href="#">RAMs</a></li>
                  <li><a href="#">Discos Duros</a></li>
                  <li><a href="#">Tarjetas de RED</a></li>
                  <li><a href="#">Usuarios</a></li>
              </ul>
          </div>
          <div class="row">
              <h1 class="page-header">Dashboard</h1>

              <h2 class="sub-header">Computadores</h2>
              <div class="table-responsive">
                  <table class="table table-striped">
                      <thead>
                      <tr>
                          <th>ID</th>
                          <th>Serial</th>
                          <th>Modelo</th>
                          <th>Fabricante</th>
                          <th>Acciones</th>
                      </tr>
                      </thead>
                      <tbody>
                      <%
                          if ( computerList != null ){
                            for (Computer computer  : computerList) {
                      %>
                      <tr>
                          <td><%=computer.getId()%></td>
                          <td><%=computer.getSerial()%></td>
                          <td><%=computer.getModel()%></td>
                          <td><%=computer.getNameManufacturer()%></td>
                          <td>
                              <a class="btn btn-info mini blue-stripe" href="<%=request.getContextPath()%>/searchComputer.do?serial=<%=computer.getSerial()%>">Edit</a>
                              <a href="#" class="btn btn-danger mini red-stripe">Delete</a>
                          </td>
                      </tr>
                      <%
                              }
                          }
                      %>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
  </div>

  <script src="js/jquery-2.2.4.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  </body>
</html>
