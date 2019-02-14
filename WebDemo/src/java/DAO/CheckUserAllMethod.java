/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author HaiDang
 */
public class CheckUserAllMethod {
    // tên người dùng có cả khoảng trắng
    public boolean CheckUserRegex(String user){
        return user.matches("^[a-zA-Z0-9_-]{6,45}$");
    }
    // kiểm tra password
    public boolean CheckPasswordRegex(String pass){
        return pass.matches("[a-zA-Z0-9]{6,30}");
    }
//    boolean 
    public boolean CheckRePassword(String pass, String rePass){
        return pass.equals(rePass);
    }
    public boolean CheckEmailRegex(String email){
        return email.matches("^\\w+@+\\w+[.]+(\\w{2,})$");
    }
    // gồm số 0 đầu tiên hoặc +8x + 9 số còn lại
    public boolean CheckNumberPhoneRegex(String numberPhone){
        return numberPhone.matches("(0|(\\+8)\\d{1})+(\\d{9})");
    }
}
