package com.furama.services.employee;

import com.furama.models.customer.Customer;
import com.furama.models.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> findAll();

    public Employee findById(Integer id);

    public void save(Employee employeeId);

    public void remove(int employee);

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findAllByDivision(String nameDivision, Pageable pageable);
}
