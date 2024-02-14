package com.assignment.cms.cart.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailId implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -3220682161836456132L;

    private long cartId;

    private long productId;
}
