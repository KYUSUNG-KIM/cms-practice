package com.assignment.cms.cart.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CART_DETAIL")
@Getter
@NoArgsConstructor
@IdClass(value = CartDetailId.class)
public class CartDetail {

    @Id
    private long cartId;

    @Id
    private long productId;

    private int quantity;
}
