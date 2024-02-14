package com.assignment.cms.product.dto;

import com.assignment.cms.product.constants.ItemCategory;
import com.assignment.cms.product.entity.BaseItem;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseItemDto {

    private ItemCategory itemCategory;

    private String name;

    private int stock;

    private int price;

    private String description;


    public static BaseItemDto of(BaseItem baseItem) {

        return BaseItemDto.builder()
                .itemCategory(baseItem.getItemCategory())
                .name(baseItem.getName())
                .stock(baseItem.getStock())
                .price(baseItem.getPrice())
                .description(baseItem.getDescription())
                .build();
    }
}
