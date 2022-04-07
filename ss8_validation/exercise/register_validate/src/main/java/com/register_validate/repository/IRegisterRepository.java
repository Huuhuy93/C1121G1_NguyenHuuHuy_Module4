package com.register_validate.repository;

import com.register_validate.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegisterRepository extends JpaRepository<Register, Integer> {
}
