package com.assignment.cms.order.entity;

import com.assignment.cms.global.entity.BaseEntity;
import com.assignment.cms.user.entity.Customer;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order", uniqueConstraints = {
        @UniqueConstraint(name = "order_unique", columnNames = "order_code")
})
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @NotNull
    @Column(name="order_code" , unique=true)
    private String orderCode;               // 주문 코드

    @NotNull
    private LocalDateTime orderDate;        // 주문 일시

    @NotNull
    private String orderName;               // 주문명

    @NotNull
    private String orderStatus;             // TODO 주문 상태

    @NotNull
    private String paymentMethod;           // TODO 결제 수단

    private int supplyPrice;                // 공급가

    private int discountAmount;             // 할인 금액

    private int netPrice;                   // 판매가

}