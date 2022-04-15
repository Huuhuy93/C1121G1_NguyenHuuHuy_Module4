package com.codegym.repository;

import com.codegym.model.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICatalogueRepository extends JpaRepository<Catalogue, Integer> {
}
