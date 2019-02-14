/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author HaiDang
 */
public class Member {
    private String user;
    private String password;
    private String email;
    private String numberPhone;
    private int position;
    private String avatar;
    private String address;
    public Member() {
    }

    public Member(String user, String password, String email, String numberPhone, String avatar, String address) {
        this.user = user;
        this.password = password;
        this.email = email;
        this.numberPhone = numberPhone;
        this.position = 1;
        this.address = address;
    }

    public Member(String user, String password, String email, String numberPhone, int position, String avatar, String address) {
        this.user = user;
        this.password = password;
        this.email = email;
        this.numberPhone = numberPhone;
        this.position = position;
        this.avatar = avatar;
        this.address = address;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member{" + "user=" + user + ", password=" + password + ", email=" + email + ", numberPhone=" + numberPhone + ", position=" + position + ", avatar=" + avatar + ", address=" + address + '}';
    }
    
}
