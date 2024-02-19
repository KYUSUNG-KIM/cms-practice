package com.assignment.cms.product.entity;

import com.assignment.cms.global.entity.BaseEntity;
import com.assignment.cms.product.constants.ItemCategory;
import com.assignment.cms.product.dto.CreateBaseItemForm;
import com.assignment.cms.user.entity.Seller;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "BASE_ITEM", uniqueConstraints = {
        @UniqueConstraint(name="BASE_ITEM_UNIQUE", columnNames = "SKU")
})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;

    private String sku;     // 재고 번호

    @Enumerated(EnumType.STRING)
    private ItemCategory itemCategory;

    private String name;

    @Column(columnDefinition = "int default 0")
    private int stock;

    private int price;

    private String description;

    @ManyToOne
    @JoinColumn(name = "SELLER_ID", nullable = false)
    private Seller seller;


    public static BaseItem from(CreateBaseItemForm form) {

        return BaseItem.builder()
                .itemCategory(ItemCategory.valueOf(form.getItemCategory()))
                .name(form.getName())
                .stock(form.getStock())
                .price(form.getPrice())
                .description(form.getDescription())
                .build();
    }
}
