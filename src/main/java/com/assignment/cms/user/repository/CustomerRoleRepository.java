package com.assignment.cms.user.repository;

import com.assignment.cms.user.entity.Customer;
import com.assignment.cms.user.entity.CustomerRole;
import com.assignment.cms.user.entity.CustomerRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRoleRepository extends JpaRepository<CustomerRole, CustomerRoleId> {

    @Modifying
    @Query(nativeQuery = true, value = "delete from customer_role where customer_id = ?1")
    public void deleteByCustomerId(long customerId);
}
