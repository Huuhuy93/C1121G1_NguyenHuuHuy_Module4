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
}
