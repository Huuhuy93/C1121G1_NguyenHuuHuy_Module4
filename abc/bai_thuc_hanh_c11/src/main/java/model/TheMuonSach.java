package model;

public class TheMuonSach {
    Integer maMuonSach;
    Integer maSach;
    Integer maHocSinh;
    Boolean trangThai;
    String ngayMuon;
    String ngayTra;

    public TheMuonSach() {
    }

    public TheMuonSach(Integer maMuonSach, Integer maSach, Integer maHocSinh, Boolean trangThai, String ngayMuon, String ngayTra) {
        this.maMuonSach = maMuonSach;
        this.maSach = maSach;
        this.maHocSinh = maHocSinh;
        this.trangThai = trangThai;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public Integer getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(Integer maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public Integer getMaSach() {
        return maSach;
    }

    public void setMaSach(Integer maSach) {
        this.maSach = maSach;
    }

    public Integer getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(Integer maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }
}
