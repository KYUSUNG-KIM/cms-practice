package com.assignment.cms.user.service;

import com.assignment.cms.user.dto.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserSignUpServiceTest {

    @Autowired
    private UserSignUpService userSignUpService;


    @Test
    @Rollback(value = false)
    void customerSignUp() {

        CustomerDto dto = new CustomerDto("goodks09@gmail.com", "1234", "TEST", "010");

        userSignUpService.customerSignUp(dto);
    }
}