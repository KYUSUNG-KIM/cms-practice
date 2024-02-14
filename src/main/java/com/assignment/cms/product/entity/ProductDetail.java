package com.assignment.cms.product.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_DETAIL")
@Getter
@NoArgsConstructor
@IdClass(value = ProductDetailId.class)
public class ProductDetail {

    @Id
    private long productId;

    @Id
    private long itemId;

    private int quantity;
}
