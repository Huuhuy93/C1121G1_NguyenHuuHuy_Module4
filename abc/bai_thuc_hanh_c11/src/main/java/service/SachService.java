package service;

import model.MuonSachDTO;
import model.Sach;
import repository.ISachRepository;
import repository.SachRepository;

import java.util.List;

public class SachService implements ISachService {

    ISachRepository iSachRepository = new SachRepository();

    @Override
    public List<Sach> selectAllSach() {
        return iSachRepository.selectAllSach();
    }

    @Override
    public List<MuonSachDTO> selectAllWithDTO() {
        return iSachRepository.selectAllWithDTO();
    }
}
