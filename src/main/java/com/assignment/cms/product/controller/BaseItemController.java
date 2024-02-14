package com.assignment.cms.product.controller;

import com.assignment.cms.global.exception.CustomException;
import com.assignment.cms.global.exception.ErrorCode;
import com.assignment.cms.product.dto.BaseItemDto;
import com.assignment.cms.product.dto.CreateBaseItemForm;
import com.assignment.cms.product.entity.BaseItem;
import com.assignment.cms.product.service.BaseItemService;
import com.assignment.cms.user.entity.Seller;
import com.assignment.cms.user.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class BaseItemController {

    private final SellerService sellerService;
    private final BaseItemService baseItemService;


    @PostMapping(value = "/base-item")
    public ResponseEntity<BaseItemDto> createBaseItem(@Valid @RequestBody CreateBaseItemForm form,
                                                      Principal principal) {

        String email = principal.getName();
        Seller seller = sellerService.getVerifiedSellerByEmail(email)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));
        BaseItem baseItem = baseItemService.createBaseItem(seller, form);

        return ResponseEntity.ok(BaseItemDto.of(baseItem));
    }
}
