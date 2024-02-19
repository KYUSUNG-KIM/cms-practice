package com.assignment.cms.security.handler;

import com.assignment.cms.security.dto.TokenDto;
import com.assignment.cms.security.provider.JwtTokenProvider;
import com.assignment.cms.security.util.HttpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtTokenProvider jwtTokenProvider;
    private final HttpUtil httpUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        String jwt = jwtTokenProvider.createToken(authentication);
        TokenDto tokenDto = new TokenDto(jwt);
        httpUtil.sendResponse(response, HttpStatus.OK, null, tokenDto);
    }
}

