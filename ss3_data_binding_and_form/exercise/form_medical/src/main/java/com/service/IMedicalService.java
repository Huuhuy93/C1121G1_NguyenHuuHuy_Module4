package com.service;

import com.model.Medical;

import java.util.List;

public interface IMedicalService {
    List<Medical> findAll();

    List<String> findQuocTich();

    void save(Medical medical);
}
