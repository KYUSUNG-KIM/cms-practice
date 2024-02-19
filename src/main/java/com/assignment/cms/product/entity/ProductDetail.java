package com.assignment.cms.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_DETAIL")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(value = ProductDetailId.class)
public class ProductDetail {

    @Id
    private long productId;

    @Id
    private long itemId;

    private int quantity;

}
