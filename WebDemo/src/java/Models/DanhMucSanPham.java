/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Hai Dang
 */
public class DanhMucSanPham {
    private int id_danh_muc;
    private String ten_danh_muc;

    public DanhMucSanPham() {
    }

    public DanhMucSanPham(int id_danh_muc, String ten_danh_muc) {
        this.id_danh_muc = id_danh_muc;
        this.ten_danh_muc = ten_danh_muc;
    }

    public int getId_danh_muc() {
        return id_danh_muc;
    }

    public void setId_danh_muc(int id_danh_muc) {
        this.id_danh_muc = id_danh_muc;
    }

    public String getTen_danh_muc() {
        return ten_danh_muc;
    }

    public void setTen_danh_muc(String ten_danh_muc) {
        this.ten_danh_muc = ten_danh_muc;
    }
    
    
}
