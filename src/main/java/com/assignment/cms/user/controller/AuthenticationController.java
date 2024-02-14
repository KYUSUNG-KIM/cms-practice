package com.assignment.cms.user.controller;

import com.assignment.cms.global.config.filter.JwtFilter;
import com.assignment.cms.user.dto.LoginDto;
import com.assignment.cms.user.dto.TokenDto;
import com.assignment.cms.user.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping(value = "/login")
    public ResponseEntity<TokenDto> login(@Valid @RequestBody LoginDto dto) {

        String accessToken = authenticationService.login(dto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, JwtFilter.AUTHORIZATION_TYPE + accessToken);

        return new ResponseEntity<>(new TokenDto(accessToken), httpHeaders, HttpStatus.OK);
    }

}
