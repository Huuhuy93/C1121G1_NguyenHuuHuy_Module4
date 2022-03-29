package repository;

import model.MuonSachDTO;
import model.Sach;

import java.util.List;

public interface ISachRepository {
    public List<Sach> selectAllSach();

    public List<MuonSachDTO> selectAllWithDTO();
}
