package com.furama.services.employee;

import com.furama.models.employee.Position;

import java.util.List;

public interface IPositionService {
    public List<Position> findAll();
}
