package vn.edu.stu.doandidong.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private Integer id;
    private String ten;
    private String anh;
    private KhoHang khohang;
    private String gia;
    private String ngayphathanh;

    public SanPham(Integer id, String ten, String anh, KhoHang khohang, String gia, String ngayphathanh) {
        this.id = id;
        this.ten = ten;
        this.anh = anh;
        this.khohang = khohang;
        this.gia = gia;
        this.ngayphathanh = ngayphathanh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public KhoHang getKhohang() {
        return khohang;
    }

    public void setKhohang(KhoHang khohang) {
        this.khohang = khohang;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getNgayphathanh() {
        return ngayphathanh;
    }

    public void setNgayphathanh(String ngayphathanh) {
        this.ngayphathanh = ngayphathanh;
    }
}
