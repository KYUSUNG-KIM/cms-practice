package com.assignment.cms.user.controller;

import com.assignment.cms.user.dto.CustomerDto;
import com.assignment.cms.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignUpController {

    private final UserSignUpService userSignUpService;


    @PostMapping(value = "/sign-up/customer")
    public ResponseEntity<String> customerSignUp(@RequestBody CustomerDto dto) {

        userSignUpService.customerSignUp(dto);

        return ResponseEntity.ok("회원가입에 성공하셨습니다.");
    }
}











