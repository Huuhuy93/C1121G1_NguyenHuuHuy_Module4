package com.register_validate.service;

import com.register_validate.model.Register;
import com.register_validate.repository.IRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements IRegisterService{
    @Autowired
    IRegisterRepository iRegisterRepository;

    @Override
    public Page<Register> findAll(Pageable pageable) {
        return iRegisterRepository.findAll(pageable);
    }

    @Override
    public void save(Register register) {
        iRegisterRepository.save(register);
    }
}
