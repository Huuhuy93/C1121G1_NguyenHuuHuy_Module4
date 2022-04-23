package com.furama.services.employee;

import com.furama.models.employee.EducationDegree;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IEducationDegreeService {
    public List<EducationDegree> findAll();
}
