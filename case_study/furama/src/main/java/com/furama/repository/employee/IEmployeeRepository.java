package com.furama.repository.employee;

import com.furama.models.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from employee inner join division on employee.division_id = division.division_id where division.division_name like concat('%',:nameDivision,'%')"
            , nativeQuery = true)
    Page<Employee> findAllByDivision(@Param("nameDivision") String nameDivision, Pageable pageable);
}
