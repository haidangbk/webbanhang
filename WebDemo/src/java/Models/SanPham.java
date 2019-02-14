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
public class SanPham {

    private int idSanPham;
    private int idDanhMuc;
    private String tenSanPham;
    private int giaSanPham;
    private String anhSanPham;
    private String cmtSanPham;
    private int hotSanPham;

    public SanPham() {
    }

    public SanPham(int idSanPham, int idDanhMuc, String tenSanPham, int giaSanPham, String anhSanPham, String cmtSanPham , int hotSanPham) {
        this.idSanPham = idSanPham;
        this.idDanhMuc = idDanhMuc;
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.anhSanPham = anhSanPham;
        this.hotSanPham = hotSanPham;
        this.cmtSanPham = cmtSanPham;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(int idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(int giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public String getAnhSanPham() {
        return anhSanPham;
    }

    public void setAnhSanPham(String anhSanPham) {
        this.anhSanPham = anhSanPham;
    }

    public int getHotSanPham() {
        return hotSanPham;
    }

    public void setHotSanPham(int hotSanPham) {
        this.hotSanPham = hotSanPham;
    }

    public String getCmtSanPham() {
        return cmtSanPham;
    }

    public void setCmtSanPham(String cmtSanPham) {
        this.cmtSanPham = cmtSanPham;
    }

    @Override
    public String toString() {
        return "SanPham{" + "idSanPham=" + idSanPham + ", idDanhMuc=" + idDanhMuc + ", tenSanPham=" + tenSanPham + ", giaSanPham=" + giaSanPham + ", anhSanPham=" + anhSanPham + ", cmtSanPham=" + cmtSanPham + ", hotSanPham=" + hotSanPham + '}';
    }

    
}
