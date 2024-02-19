package com.assignment.cms.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserSignUpServiceTest {

    @Autowired
    private UserSignUpService userSignUpService;


//    @Test
//    @Rollback(value = false)
//    void customerSignUp() {
//
//        CustomerDto dto = new CustomerDto("goodks09@gmail.com", "1234", "TEST", "010");
//
//        userSignUpService.customerSignUp(dto);
//    }
}