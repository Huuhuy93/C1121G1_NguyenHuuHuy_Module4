package com.furama.services.employee.impl;

import com.furama.models.employee.EducationDegree;
import com.furama.repository.employee.IEducationDegreeRepository;
import com.furama.services.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
