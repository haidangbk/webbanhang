/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Timestamp;

/**
 *
 * @author HaiDang
 */
public class Bill {
    private int billID;
    private String user;
    private String name;
    private String numberPhone;
    private String address;
    private int total;
    private Timestamp date;

    public Bill() {
    }

    public Bill(int billID, String user, String name, String numberPhone, String address, int total, Timestamp date) {
        this.billID = billID;
        this.user = user;
        this.name = name;
        this.numberPhone = numberPhone;
        this.address = address;
        this.total = total;
        this.date = date;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
    
    
}

