package com.mimos.inventario.entities;

/**
 * Created by Daniel on 29/05/2016.
 */
public class Computer {

    private Integer id;
    private String serial;
    private String model;
    private String networkName;
    private Integer idUser;
    private String userName;
    private Integer idManufacturer;
    private String nameManufacturer;

    public Computer(Integer id, String serial, String model, String networkName, Integer idUser, String userName, Integer idManufacturer, String nameManufacturer) {
        this.setId(id);
        this.setSerial(serial);
        this.setModel(model);
        this.setNetworkName(networkName);
        this.setIdUser(idUser);
        this.setUserName(userName);
        this.setIdManufacturer(idManufacturer);
        this.setNameManufacturer(nameManufacturer);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(Integer idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getNameManufacturer() {
        return nameManufacturer;
    }

    public void setNameManufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
    }
}
