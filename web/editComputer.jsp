<%@ page import="com.mimos.inventario.entities.Computer" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mimos.inventario.entities.User" %>
<%@ page import="com.mimos.inventario.entities.Manufacturer" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 07/06/2016
  Time: 11:58 AM
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
    List<User> userList = request.getAttribute("userList") != null ? (List<User>) request.getAttribute("userList") : null;
    List<Manufacturer> manufacturerList = request.getAttribute("manufacturerList") != null ? (List<Manufacturer>) request.getAttribute("manufacturerList") : null;
%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inventario MIMO'S</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/index.css" />
    <script src="js/jquery-2.2.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<%
    if (message != null){
%>
<script type="text/javascript">
    $(document).ready(function () {
        var idManufacturer = '<%=idManufacturer%>';
        var idUser = '<%idUser%>';
        $("#idManufacturer option[value=" + idManufacturer + "]").attr("selected", true);
        $("#idUser option[value=" + idUser + "]").attr("selected", true);
    })
</script>
<%
    }
%>

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

            <h2 class="sub-header">Editar Computador</h2>

            <form class="form-horizontal">
                <fieldset>

                    <!-- Hidden Input -->
                    <input id="id" name="id" type="hidden" value="<%=id%>">

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="serial">Serial</label>
                        <div class="col-md-4">
                            <input id="serial" name="serial" class="form-control input-md" required="" type="text" value="<%=serial%>">
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="model">Modelo</label>
                        <div class="col-md-4">
                            <input id="model" name="model" class="form-control input-md" required="" type="text" value="<%=model%>">
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="idManufacturer">Fabricante</label>
                        <div class="col-md-4">
                            <select id="idManufacturer" name="idManufacturer" class="form-control">
                                <option value="">Seleccione un fabricante</option>
                                <%
                                    for (int i = 0; manufacturerList != null && i < manufacturerList.size(); i++) {
                                        Manufacturer manufacturer = manufacturerList.get(i);
                                %>
                                <option value="<%=manufacturer.getId()%>"><%=manufacturer.getName()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="networkName">Nombre en Red</label>
                        <div class="col-md-4">
                            <input id="networkName" name="networkName" class="form-control input-md" type="text" value="<%=networkName%>">
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="idUser">Usuario</label>
                        <div class="col-md-4">
                            <select id="idUser" name="idUser" class="form-control">
                                <option value="">Seleccione un usuario</option>
                                <%
                                    for (int i = 0; userList != null && i < userList.size(); i++) {
                                        User user = userList.get(i);
                                %>
                                <option value="<%=user.getId()%>"><%=user.getUserName()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>

                    <!-- Button (Double) -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="button1id"></label>
                        <div class="col-md-8">
                            <button id="button1id" name="button1id" class="btn btn-success">Editar</button>
                            <button id="button2id" name="button2id" class="btn btn-danger">Cancelar</button>
                        </div>
                    </div>

                </fieldset>
            </form>

        </div>
    </div>
</div>

<script src="js/jquery-2.2.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
