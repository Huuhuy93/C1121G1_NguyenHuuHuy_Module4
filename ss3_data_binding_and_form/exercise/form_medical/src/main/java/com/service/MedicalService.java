package com.service;

import com.model.Medical;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedicalService implements IMedicalService {
    private static Map<Integer, Medical> medicalMap;
    private static List<String> phuongTienList;

    static {
        medicalMap = new HashMap<>();
        medicalMap.put(1, new Medical(101, "Nguyen Van A", "1990-03-02", 0, "Việt Nam", "202123212", "Tàu bay", "VN123", "V1", "2022-01-02", "2022-02-01", "không", "Đà Nẵng", "Hải Châu", "Xuân Hà", "87 Ông Ích Khiêm", "0901202342", "abc@gmail.com"));
        medicalMap.put(2, new Medical(203, "Nguyen Van B", "1993-05-10", 1, "Việt Nam", "192143211", "Ô tô", null, null, "2022-01-02", "2022-02-01", "không", "Đà Nẵng", "Hải Châu", "Xuân Hà", "87 Ông Ích Khiêm", "0901202342", null));
        phuongTienList = new ArrayList<>();
        phuongTienList.add("Tàu bay");
        phuongTienList.add("Tàu thuyền");
        phuongTienList.add("Ô tô");
        phuongTienList.add("Khác (Ghi rõ)");

    }

    @Override
    public List<Medical> findAll() {
        return new ArrayList<>(medicalMap.values());
    }

    @Override
    public List<String> findQuocTich() {
        return phuongTienList;
    }

    @Override
    public void save(Medical medical) {
        Integer idAutoIcrement = (int) (Math.random() * 1000);
        medical.setId(idAutoIcrement);
        medicalMap.put(medical.getId(), medical);
    }
}
