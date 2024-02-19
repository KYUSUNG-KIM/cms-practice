package com.assignment.cms.product.service;

import com.assignment.cms.global.exception.CustomException;
import com.assignment.cms.global.exception.ErrorCode;
import com.assignment.cms.product.constants.ItemCategory;
import com.assignment.cms.product.dto.CreateBaseItemForm;
import com.assignment.cms.product.entity.BaseItem;
import com.assignment.cms.product.repository.BaseItemRepository;
import com.assignment.cms.user.entity.Seller;
import com.assignment.cms.user.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BaseItemService {

    private final SellerService sellerService;

    private final BaseItemRepository baseItemRepository;


    @Transactional
    public BaseItem createBaseItem(String email, CreateBaseItemForm form) {

        Seller seller = sellerService.getVerifiedSellerByEmail(email)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));

        ItemCategory itemCategory = ItemCategory.valueOf(form.getItemCategory());
        String sku = createSku(itemCategory);

        BaseItem baseItem = BaseItem.from(form);
        baseItem.setSeller(seller);
        baseItem.setSku(sku);

        return baseItemRepository.save(baseItem);
    }


    // 카테고리 코드 앞 2자리 + 랜덤코드 6자리
    private String createSku(ItemCategory itemCategory) {

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        uuid = uuid.substring(0, 6).toUpperCase();

        return itemCategory.name().substring(0, 2).toUpperCase() + uuid;

    }
}
