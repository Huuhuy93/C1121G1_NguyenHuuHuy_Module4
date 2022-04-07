package com.register_validate.service;

import com.register_validate.model.Register;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRegisterService {
    Page<Register> findAll(Pageable pageable);
    void save(Register register);
}
