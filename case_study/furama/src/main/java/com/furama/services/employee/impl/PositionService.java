package com.furama.services.employee.impl;

import com.furama.models.employee.Position;
import com.furama.repository.employee.IPositionRepository;
import com.furama.services.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
