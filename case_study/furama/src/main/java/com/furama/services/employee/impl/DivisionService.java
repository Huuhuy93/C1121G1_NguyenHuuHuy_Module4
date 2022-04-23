package com.furama.services.employee.impl;

import com.furama.models.employee.Division;
import com.furama.repository.employee.IDivisionRepository;
import com.furama.services.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
