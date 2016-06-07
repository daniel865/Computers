package com.mimos.inventario.entities;

/**
 * Created by ASUS on 07/06/2016.
 */
public class User {

    private Integer id;
    private String userName;
    private String identification;
    private String name;
    private String lastName1;
    private String lastName2;
    private Integer idPosition;
    private Integer idArea;

    public User(Integer id, String userName, String identification, String name, String lastName1, String lastName2, Integer idPosition, Integer idArea) {
        this.id = id;
        this.userName = userName;
        this.identification = identification;
        this.name = name;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.idPosition = idPosition;
        this.idArea = idArea;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", identification='" + identification + '\'' +
                ", name='" + name + '\'' +
                ", lastName1='" + lastName1 + '\'' +
                ", lastName2='" + lastName2 + '\'' +
                ", idPosition=" + idPosition +
                ", idArea=" + idArea +
                '}';
    }
}
