package com.assignment.cms.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailId implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -3220682161836456131L;

    private long productId;

    private long itemId;
}
