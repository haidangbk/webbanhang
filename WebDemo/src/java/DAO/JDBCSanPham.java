/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.DanhMucSanPham;
import Models.SanPham;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hai Dang
 */
public class JDBCSanPham {

    public static Connection getJDBCSanPham() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/webbanhang";
        String user = "root";
        String pass = "152132488";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // lấy danh mục
    public static ArrayList<DanhMucSanPham> getListTenDanhMuc() {
        try {
            Connection conn = getJDBCSanPham();
            String sql = "SELECT * FROM webbanhang.product_type";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<DanhMucSanPham> listTenDanhMuc = new ArrayList<>();
            while (rs.next()) {
                listTenDanhMuc.add(new DanhMucSanPham(rs.getInt("id_danh_muc"),
                        rs.getString("ten_danh_muc")));
            }
            return listTenDanhMuc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // Lấy list sản phẩm dựa vào tên danh mục sản phẩm

    public static ArrayList<SanPham> getListSanPham(String tenDanhMuc) {
        try (Connection conn = getJDBCSanPham()) {
            String sql = "SELECT * FROM webbanhang.product inner join"
                    + " webbanhang.product_type on webbanhang.product.id_danh_muc"
                    + " = webbanhang.product_type.id_danh_muc"
                    + " where ten_danh_muc = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, tenDanhMuc);
            ResultSet rs = pst.executeQuery();
            ArrayList<SanPham> listSP = new ArrayList<>();
            while (rs.next()) {
                listSP.add(new SanPham(rs.getInt("id_san_pham"),
                        rs.getInt("id_danh_muc"),
                        rs.getString("ten_san_pham"),
                        rs.getInt("gia_san_pham"),
                        rs.getString("anh_san_pham"),
                        rs.getString("cmt_san_pham"),
                        rs.getInt("top_san_pham")));
            }
            return listSP;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // Lấy ? sản phẩm hot dựa vào tên danh mục sản phẩm.

    public static ArrayList<SanPham> getTopSanPham(String tenDanhMuc, int soSanPham) {
        try (Connection conn = getJDBCSanPham()) {
            String sql = "SELECT * FROM webbanhang.product inner join"
                    + " webbanhang.product_type on webbanhang.product.id_danh_muc"
                    + " = webbanhang.product_type.id_danh_muc WHERE ten_danh_muc"
                    + " = ? ORDER BY top_san_pham DESC LIMIT ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, tenDanhMuc);
            pst.setInt(2, soSanPham);
            ResultSet rs = pst.executeQuery();
            ArrayList<SanPham> listSP = new ArrayList<>();
            while (rs.next()) {
                listSP.add(new SanPham(rs.getInt("id_san_pham"),
                        rs.getInt("id_danh_muc"),
                        rs.getString("ten_san_pham"),
                        rs.getInt("gia_san_pham"),
                        rs.getString("anh_san_pham"),
                        rs.getString("cmt_san_pham"),
                        rs.getInt("top_san_pham")));
            }
            return listSP;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Lấy Sản phẩm dựa vào mã sản phẩm
    public static SanPham getSanPham(int idSanPham) {
        try (Connection conn = getJDBCSanPham()) {
            String sql = "SELECT * FROM webbanhang.product WHERE id_san_pham=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, idSanPham);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(
                        rs.getInt("id_san_pham"),
                        rs.getInt("id_danh_muc"),
                        rs.getString("ten_san_pham"),
                        rs.getInt("gia_san_pham"),
                        rs.getString("anh_san_pham"),
                        rs.getString("cmt_san_pham"),
                        rs.getInt("top_san_pham")
                );
                return sp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
