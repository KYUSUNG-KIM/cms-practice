package com.assignment.cms.order.entity;

import com.assignment.cms.global.entity.BaseEntity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_DETAIL")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderDetailId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @NotNull
    private String productCode;     // 상품 코드

    @NotNull
    private String productName;     // 상품명

    @NotNull
    private String orderStatus;     // 주문 상태

    private int supplyPrice;        // 공급가

    private int discountAmount;     // 할인 금액

    private int netPrice;           // 판매가

    private int quantity;           // 수량

    private int totalAmount;        // 총 금액 (판매가 * 수량)


}
