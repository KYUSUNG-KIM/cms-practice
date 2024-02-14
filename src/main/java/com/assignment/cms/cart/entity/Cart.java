package com.assignment.cms.cart.entity;

import com.assignment.cms.global.entity.BaseEntity;
import com.assignment.cms.user.entity.Customer;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CART")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private int totalProductCount;          // 총 상품 개수
}
