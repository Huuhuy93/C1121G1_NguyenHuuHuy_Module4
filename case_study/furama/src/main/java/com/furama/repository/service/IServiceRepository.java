package com.furama.repository.service;

import com.furama.models.service.ServiceFurama;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IServiceRepository extends JpaRepository<ServiceFurama, Integer> {
    @Query(value = "select * from service where service_name like concat('%',:name,'%') ", nativeQuery = true)
    Page<ServiceFurama> findAllByServiceName(@Param("name") String name, Pageable pageable);
}
