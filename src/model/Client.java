/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Client {
     private String name;
    private short years;
    private int DNI;
    private int mobile;
    private String sex;
    private String address;

    public Client(String name, short years, int DNI, int mobile, String sex, String address) {
        this.name = name;
        this.years = years;
        this.DNI = DNI;
        this.mobile = mobile;
        this.sex = sex;
        this.address = address;
        
    }

    public String getName() {
        
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getYears() {
        return years;
    }

    public void setYears(short years) {
        this.years = years;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    

}
