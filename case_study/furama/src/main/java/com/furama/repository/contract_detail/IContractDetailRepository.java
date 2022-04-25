package com.furama.repository.contract_detail;

import com.furama.models.contract.Contract;
import com.furama.models.contract_detail.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
//    @Query(value = "select * from contract_detail\n" +
//            " join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id \n" +
//            " where attach_service.attach_service_name like concat('%',:nameAttach,'%')"
//            , nativeQuery = true)
//    Page<ContractDetail> findAllByAttachService(@Param("nameAttach") String nameAttach, Pageable pageable);
}
