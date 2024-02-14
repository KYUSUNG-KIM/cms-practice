package com.assignment.cms.product.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateBaseItemForm {

    @NotNull
    private String itemCategory;

    @NotNull
    private String name;

    @Min(1)
    private int stock;

    @Min(1)
    private int price;

    private String description;
}
