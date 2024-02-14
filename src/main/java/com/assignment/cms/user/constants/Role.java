package com.assignment.cms.user.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public enum Role {

    CUSTOMER("고객", "USER"),
    SELLER("판매자", "USER");

    private final String title;
    private final String authorities;
}
