package com.assignment.cms.product.entity;

import com.assignment.cms.user.entity.Seller;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @NotNull
    @Column(name="product_code" , unique=true)
    private String productCode;     // 상품 코드

    private String name;            // 상품명

    private int supplyPrice;        // 공급가

    private int discountAmount;     // 할인 금액

    private int retailPrice;        // 소비자 가격
    
    private String description;     // 상품 설명

}
