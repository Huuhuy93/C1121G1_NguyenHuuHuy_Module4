package com.furama.services.contract_detail.impl;

import com.furama.models.contract_detail.AttachService;
import com.furama.repository.contract_detail.IAttachServiceRepository;
import com.furama.services.contract_detail.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {

    @Autowired
    private IAttachServiceRepository iAttachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return iAttachServiceRepository.findAll();
    }
}
