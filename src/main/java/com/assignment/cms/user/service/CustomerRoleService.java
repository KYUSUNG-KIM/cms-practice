package com.assignment.cms.user.service;

import com.assignment.cms.user.constants.Role;
import com.assignment.cms.user.entity.CustomerRole;
import com.assignment.cms.user.repository.CustomerRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerRoleService {

    private final CustomerRoleRepository customerRoleRepository;


    @Transactional
    public void updateCustomerRoles(long customerId, final List<String> roles) {

        customerRoleRepository.deleteByCustomerId(customerId);

        for (String role : roles) {
            CustomerRole customerRole = new CustomerRole(customerId, role);

            customerRoleRepository.save(customerRole);
        }
    }

}
