package com.assignment.cms.user.controller;

import com.assignment.cms.user.dto.CustomerDto;
import com.assignment.cms.user.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping(value = "/customers/{email}")
//    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<CustomerDto> getCustomerInfo(@PathVariable String email) {

        CustomerDto customerDto = customerService.getCustomerDto(email);

        return ResponseEntity.ok(customerDto);
    }

}
