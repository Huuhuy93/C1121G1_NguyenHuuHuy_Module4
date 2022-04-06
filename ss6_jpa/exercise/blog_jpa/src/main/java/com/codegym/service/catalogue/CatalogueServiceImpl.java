package com.codegym.service.catalogue;

import com.codegym.model.Catalogue;
import com.codegym.repository.ICatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogueServiceImpl implements ICatalogueService{
    @Autowired
    ICatalogueRepository iCatalogueRepository;

    @Override
    public List<Catalogue> findAll() {
        return iCatalogueRepository.findAll();
    }

    @Override
    public Optional<Catalogue> findById(Integer id) {
        return iCatalogueRepository.findById(id);
    }

    @Override
    public void save(Catalogue catalogue) {
        iCatalogueRepository.save(catalogue);
    }

    @Override
    public void remove(Integer id) {
        iCatalogueRepository.deleteById(id);
    }
}
