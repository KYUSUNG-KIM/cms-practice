package com.assignment.cms.user.controller;

import com.assignment.cms.global.dto.CommonResponse;
import com.assignment.cms.user.dto.CustomerSignUpForm;
import com.assignment.cms.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignUpController {

    private final UserSignUpService userSignUpService;


    @PostMapping(value = "/sign-up/customer")
    public CommonResponse customerSignUp(@RequestBody CustomerSignUpForm dto) {

        userSignUpService.customerSignUp(dto);

        return new CommonResponse("회원가입에 성공하셨습니다.");
    }
}











