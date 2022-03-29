package model;

public class MuonSachDTO {
    Integer maMuonSach;
    String tenSach;
    String tacGia;
    String tenHocSinh;
    String lop;
    String ngayMuon;
    String ngayTra;

    public MuonSachDTO() {
    }

    public MuonSachDTO(String tenSach, String tacGia, String tenHocSinh, String lop, String ngayMuon, String ngayTra) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.tenHocSinh = tenHocSinh;
        this.lop = lop;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public MuonSachDTO(Integer maMuonSach, String tenSach, String tacGia, String tenHocSinh, String lop, String ngayMuon, String ngayTra) {
        this.maMuonSach = maMuonSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.tenHocSinh = tenHocSinh;
        this.lop = lop;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public Integer getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(Integer maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTenHocSinh() {
        return tenHocSinh;
    }

    public void setTenHocSinh(String tenHocSinh) {
        this.tenHocSinh = tenHocSinh;
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
