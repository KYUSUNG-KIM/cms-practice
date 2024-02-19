package com.assignment.cms.product.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateProductForm {

    @NotNull
    private String name;

    @Min(1)
    private int retailPrice;

    private String description;
}
