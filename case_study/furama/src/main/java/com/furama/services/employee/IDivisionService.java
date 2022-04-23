package com.furama.services.employee;

import com.furama.models.employee.Division;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IDivisionService {
        public List<Division> findAll();
}
