package com.furama.services.employee.impl;

import com.furama.models.customer.Customer;
import com.furama.models.employee.Employee;
import com.furama.repository.employee.IEmployeeRepository;
import com.furama.services.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;


    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.getById(id);
    }

    @Override
    public void save(Employee employee) {
        this.iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(int employeeId) {
        this.iEmployeeRepository.deleteById(employeeId);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllByDivision(String nameDivision, Pageable pageable) {
        return iEmployeeRepository.findAllByDivision(nameDivision, pageable);
    }


}
