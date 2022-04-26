package com.furama.repository.customer;

import com.furama.models.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where customer_code like concat('%',:code,'%') and " +
            "customer_name like concat('%',:name,'%') and customer_phone like concat('%',:phone,'%') ", nativeQuery = true)
    Page<Customer> findAllByCodeAndNameAndPhoneContaining(@Param("code") String code, @Param("name") String name,
                                                          @Param("phone") String phone, Pageable pageable);

    @Query(value = "select customer.customer_code as customerCode, customer.customer_name as customerName, customer.customer_id_card as customerIdCard, " +
            " customer.customer_phone as customerPhone, customer.customer_email as customerEmail, service_furama.service_name as serviceName, " +
            " contract.contract_start_date as contractStartDate, contract.contract_end_date as contractEndDate, " +
            " attach_service.attach_service_name as attachServiceName, " +
            " (ifnull(service_furama.service_cost, 0) + ifnull(attach_service.attach_service_cost * contract_detail.quantity, 0)) as total " +
            " from contract " +
            " left join customer on contract.customer_id = customer.customer_id " +
            " left join service_furama on contract.service_id = service_furama.service_id " +
            " left join contract_detail on contract.contract_id = contract_detail.contract_id " +
            " left join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id ",
            countQuery = "select count(*) from contract " +
                    " left join customer on contract.customer_id = customer.customer_id " +
                    " left join service_furama on contract.service_id = service_furama.service_id " +
                    " left join contract_detail on contract.contract_id = contract_detail.contract_id " +
                    " left join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id ",
    nativeQuery = true)
    <T> Page<T> findAllCustomerUseService(Class<T> classType, Pageable pageable);
}
