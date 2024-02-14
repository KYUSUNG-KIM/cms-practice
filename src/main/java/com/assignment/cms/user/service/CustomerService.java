package com.assignment.cms.user.service;

import com.assignment.cms.global.exception.CustomException;
import com.assignment.cms.global.exception.ErrorCode;
import com.assignment.cms.user.dto.CustomerDto;
import com.assignment.cms.user.entity.Customer;
import com.assignment.cms.user.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    @Transactional(readOnly = true)
    public Optional<Customer> getVerifiedCustomerByEmail(String email) {

        return customerRepository.findOneByEmailAndVerifyIsTrue(email);
    }

    @Transactional(readOnly = true)
    public CustomerDto getCustomerDto(String email) {

        Customer customer = customerRepository.findOneByEmailAndVerifyIsTrue(email)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));

        return CustomerDto.of(customer);
    }

    @Transactional(readOnly = true)
    public boolean isExistEmail(String email) {

        return customerRepository.existsByEmail(email);
    }

    @Transactional
    public Customer save(Customer customer) {

        return customerRepository.save(customer);
    }
}
