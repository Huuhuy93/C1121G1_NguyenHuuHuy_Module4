package com.furama.repository.employee;

import com.furama.models.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
