package service;

import model.MuonSachDTO;
import model.Sach;

import java.util.List;

public interface ISachService {
    public List<Sach> selectAllSach();

    public List<MuonSachDTO> selectAllWithDTO();
}
