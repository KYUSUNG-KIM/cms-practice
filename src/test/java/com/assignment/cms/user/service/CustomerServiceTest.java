package com.assignment.cms.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    void isExistEmail() {

        boolean isExistEmail = customerService.isExistEmail("goodks09@naver.com");

        Assert.isTrue(isExistEmail);

    }
}