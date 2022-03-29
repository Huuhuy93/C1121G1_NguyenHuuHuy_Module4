package model;

public class HocSinh {
    Integer maHocSinh;
    String hoTen;
    String lop;

    public HocSinh() {
    }

    public HocSinh(Integer maHocSinh, String hoTen, String lop) {
        this.maHocSinh = maHocSinh;
        this.hoTen = hoTen;
        this.lop = lop;
    }

    public Integer getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(Integer maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
