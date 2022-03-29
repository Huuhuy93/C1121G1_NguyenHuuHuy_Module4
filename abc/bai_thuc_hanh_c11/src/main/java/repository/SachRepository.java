package repository;

import model.MuonSachDTO;
import model.Sach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachRepository implements ISachRepository{
    private static final String SELECT_ALL_SACH = "select * from sach;";
    private static final String SELECT_ALL_WITH_DTO = "select the_muon_sach.ma_muon_sach, sach.ten_sach, sach.tac_gia, hoc_sinh.ho_ten, hoc_sinh.lop, the_muon_sach.ngay_muon, the_muon_sach.ngay_tra\n" +
            "from the_muon_sach join hoc_sinh on the_muon_sach.ma_hoc_sinh = hoc_sinh.ma_hoc_sinh\n" +
            "join sach on the_muon_sach.ma_sach = sach.ma_sach;";


    private BaseC11Repository baseC11Repository = new BaseC11Repository();
    @Override
    public List<Sach> selectAllSach() {

        List<Sach> sachList = new ArrayList<>();
        Connection connection = null;

        try {
            connection = baseC11Repository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SACH);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer maSach = resultSet.getInt("ma_sach");
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                Integer soLuong = resultSet.getInt("so_luong");
                sachList.add(new Sach(maSach, tenSach, tacGia, moTa, soLuong));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return sachList;
    }

    @Override
    public List<MuonSachDTO> selectAllWithDTO() {
        List<MuonSachDTO> muonSachDTOList = new ArrayList<>();
        Connection connection = null;

        try {
            connection = baseC11Repository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WITH_DTO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer maMuonSach = resultSet.getInt("ma_muon_sach");
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String tenHocSinh = resultSet.getString("ho_ten");
                String lop = resultSet.getString("lop");
                String ngayMuon = resultSet.getString("ngay_muon");
                String ngayTra = resultSet.getString("ngay_tra");
                muonSachDTOList.add(new MuonSachDTO(maMuonSach, tenSach, tacGia, tenHocSinh,lop, ngayMuon, ngayTra));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return muonSachDTOList;
    }
}
