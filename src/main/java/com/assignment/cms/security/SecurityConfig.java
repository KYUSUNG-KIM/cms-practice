package com.assignment.cms.security;

import com.assignment.cms.security.filter.JsonUsernamePasswordAuthenticationFilter;
import com.assignment.cms.security.filter.JwtFilter;
import com.assignment.cms.security.handler.JwtAccessDeniedHandler;
import com.assignment.cms.security.handler.JwtAuthenticationEntryPoint;
import com.assignment.cms.security.handler.LoginFailureHandler;
import com.assignment.cms.security.handler.LoginSuccessHandler;
import com.assignment.cms.security.provider.CustomAuthenticationProvider;
import com.assignment.cms.security.provider.JwtTokenProvider;
import com.assignment.cms.security.service.CustomUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final CustomUserDetailsService customUserDetailsService;

    private final ObjectMapper objectMapper;
    private final LoginSuccessHandler loginSuccessHandler;
    private final LoginFailureHandler loginFailureHandler;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/h2-console/**", "/favicon.ico");
    }

//    @Bean
//    public JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter() {
//        JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter = new JsonUsernamePasswordAuthenticationFilter();
//        jsonUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManager());
//        return jsonUsernamePasswordAuthenticationFilter;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/custom/authentication").permitAll()
                .antMatchers("/sign-up/**").permitAll()
                .anyRequest().authenticated()

//                .and()
//                .formLogin()
//                .loginPage("/custom/login")
//                    .loginProcessingUrl("/custom/authentication")
//                    .usernameParameter("custom_username")
//                    .passwordParameter("custom_password")
//                    .successHandler((request, response, authentication) -> {
//                        // 로그인 성공 시 처리할 핸들러 설정
//                        System.out.println("Login Success");
//
//                        String accessToken = jwtTokenProvider.createToken(authentication);
//
//                        response.setStatus(200); // 성공 상태 코드 반환
//                        response.getWriter().write(String.valueOf(new TokenDto(accessToken)));
//                        response.getWriter().flush();
//                    })
//                    .failureHandler((request, response, exception) -> {
//                        System.out.println("Login Fail");
//                        response.setStatus(401); // 실패 상태 코드 반환
//                    })
//                .permitAll()
//
//                .and()
//                .httpBasic()

                .and()
                .addFilterBefore(jsonIdPwAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
//                .addFilterBefore(jsonUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)


        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return authentication ->
                new CustomAuthenticationProvider(customUserDetailsService, passwordEncoder())
                        .authenticate(authentication);
    }

    @Bean
    public JsonUsernamePasswordAuthenticationFilter jsonIdPwAuthenticationFilter() {
        JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter
                = new JsonUsernamePasswordAuthenticationFilter(objectMapper, loginSuccessHandler, loginFailureHandler);
        jsonUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManager());
        return jsonUsernamePasswordAuthenticationFilter;
    }

}
