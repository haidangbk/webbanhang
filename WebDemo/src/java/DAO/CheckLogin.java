/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.JDBCConnection.getJDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HaiDang
 */
public class CheckLogin {

    // Kiểm tra tài khoản mật khẩu đăng nhập chính xác k?
    public boolean checkLogin(String user, String password) {
        JDBCConnection jdbcc = new JDBCConnection();
        String sql = "SELECT * FROM webbanhang.account WHERE accountUser=? AND passwordUser=?";
        try (Connection conn = getJDBCConnection()) {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
           if(rs.next()){
               return  true;
           }
        } catch (SQLException ex) {
            Logger.getLogger(CheckLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
