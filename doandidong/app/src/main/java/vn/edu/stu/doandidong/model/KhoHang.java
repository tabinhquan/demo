package vn.edu.stu.doandidong.model;

import java.util.Objects;

public class KhoHang {
    private Integer makhohang;
    private String tenkhohang;
    private static int sma = 1;

    public KhoHang(String tenkhohang){
        this.makhohang = sma++;
        this.tenkhohang = tenkhohang;
    }

    @Override
    public String toString() {return makhohang + " " + tenkhohang;}

    public Integer getMa() {return makhohang;}

    public String getTenKhoHang() {return tenkhohang;}

    public  void setTenkhohang (String tenkhohang) { this.tenkhohang = tenkhohang;}

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KhoHang khoHang = (KhoHang) o;
        return Objects.equals(tenkhohang, khoHang.tenkhohang);
    }

    @Override
    public int hashCode() {return Objects.hash(tenkhohang);}
}
