/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Member;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 1. Tạo connect database 2. Kiểm tra tên người dùng tồn tại chưa? 3. Thêm
 * người dùng vào database 4. Load thông tin của 1 member 5. Thay đổi thông tin
 * 1 member 6. Kiểm tra tên người dùng và email nhằm mục đích lấy lại mk
 *
 * @author HaiDang
 */
public class JDBCConnection {

    //1. Tạo connect database
    public static Connection getJDBCConnection() {
//        String url = "jdbc:mysql://localhost:3306/webbanhang";
//        String user = "root";
//        String pass = "152132488";
        try {
            Class.forName(DBConfig.driver);
            return DriverManager.getConnection(DBConfig.url, DBConfig.user, DBConfig.pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //2. Kiểm tra tên người dùng tồn tại chưa?
    public boolean CheckUserExist(String user) {
        String sql = "SELECT id FROM webbanhang.account WHERE accountUser = ?";
        try (Connection conn = getJDBCConnection()) {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user);
            return pst.executeQuery().next();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //3. Thêm người dùng vào database
    public boolean AddUserDatabase(Member nmb) {
        String sql = "INSERT INTO webbanhang.account VALUES(null,?,?,?,?,1,null,null)";
        try (Connection conn = getJDBCConnection()) {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nmb.getUser());
            pst.setString(2, nmb.getPassword());
            pst.setString(3, nmb.getEmail());
            pst.setString(4, nmb.getNumberPhone());
            int rs = pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //4. Load thông tin của 1 member
    public Member getMember(String user, String password) {
        String sql = "SELECT * FROM webbanhang.account"
                + " WHERE accountUser = ? AND  passwordUser = ?";
        try (Connection conn = getJDBCConnection()) {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Member nmb = new Member(rs.getString("accountUser"),
                        rs.getString("passwordUser"),
                        rs.getString("email"),
                        rs.getString("numberPhone"),
                        rs.getInt("idPosition"),
                        rs.getString("avatar"),
                        rs.getString("address"));
                return nmb;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //5. Thay đổi thông tin 1 member
    public static boolean updateMember(Member member) {
        try (Connection conn = getJDBCConnection()) {
            String update = "UPDATE webbanhang.account SET email=?, numberPhone=?,"
                    + " address=? WHERE accountUser=?";
            PreparedStatement pst = conn.prepareStatement(update);
            pst.setString(1, member.getEmail());
            pst.setString(2, member.getNumberPhone());
            pst.setString(3, member.getAddress());
            pst.setString(4, member.getUser());
            pst.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //6. Kiểm tra tên người dùng và email nhằm mục đích lấy lại mk
    public static boolean checkEmailExist(String user, String email) {
        try (Connection conn = getJDBCConnection()) {
            String sql = "SELECT id FROM webbanhang.account WHERE accountUser=? and email=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, email);
            return pst.executeQuery().next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //7. Khôi phục lại mật khẩu người dùng khi quên mk
    public static boolean recoveryPassword(String email, String newPassword) {
        Connection conn = getJDBCConnection();
        String sql = "UPDATE webbanhang.account SET passwordUser=? WHERE email=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, newPassword);
            pst.setString(2, email);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Lấy ra toàn bộ list thành viên
    public static ArrayList<Member> getAllMember() {
        ArrayList<Member> listMember = new ArrayList<>();
        // Hiển thị sắp xếp theo tên a->z 
        try (Connection conn = getJDBCConnection()) {
            String sql = "SELECT * FROM webbanhang.account ORDER BY (accountUser)";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Member mb = new Member(rs.getString("accountUser"),
                        rs.getString("passwordUser"),
                        rs.getString("email"),
                        rs.getString("numberPhone"),
                        rs.getInt("idPosition"),
                        rs.getString("avatar"),
                        rs.getString("address"));
                if (mb.getPosition() < 3) {
                    listMember.add(mb);
                }
            }
            return listMember;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Xóa 1 thành viên
    public static boolean deleteMember(String accountUser) {
        try (Connection conn = getJDBCConnection()) {
            String sql = "DELETE FROM webbanhang.account WHERE accountUser=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, accountUser);
            int rs = pst.executeUpdate();
            if (rs != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Tăng cấp của thành viên
    public static int levelMember(String accountUser) {
        try (Connection conn = getJDBCConnection()) {
            String sql = "SELECT idPosition FROM webbanhang.account WHERE accountUser =? ";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, accountUser);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt("idPosition");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public static boolean changeLevelMember(String accountUser, String change) {
        try (Connection conn = getJDBCConnection()) {
            String sql = "UPDATE webbanhang.account SET idPosition= ? WHERE accountUser=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            if (change.equals("+")) {
                pst.setInt(1, levelMember(accountUser) + 1);
            } else {
                pst.setInt(1, levelMember(accountUser) - 1);
            }
            pst.setString(2, accountUser);
            int rs = pst.executeUpdate();
            if (rs != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Mã hóa mật khẩu ng dùng (Chưa dùng tới)
    public static String encryption(String str) {
        byte[] defaultBytes = str.getBytes();
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte messageDigest[] = algorithm.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xFF & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            str = hexString + "";
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return str;
    }
    
}
