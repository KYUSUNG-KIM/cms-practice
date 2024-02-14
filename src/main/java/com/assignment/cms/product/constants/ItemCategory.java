package com.assignment.cms.product.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ItemCategory {

    CLOTHES("의류"),
    FOOD("음식"),
    DIGITAL("디지털"),

    ;


    private final String title;


    @JsonCreator
    public static ItemCategory fromValue(String value) {
        try{
            return valueOf(value);
        }
        catch(Exception e) {
            return null;
        }
    }
}
