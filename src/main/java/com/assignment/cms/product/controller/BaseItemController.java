package com.assignment.cms.product.controller;

import com.assignment.cms.global.dto.CommonResponse;
import com.assignment.cms.product.dto.BaseItemDto;
import com.assignment.cms.product.dto.CreateBaseItemForm;
import com.assignment.cms.product.entity.BaseItem;
import com.assignment.cms.product.service.BaseItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class BaseItemController {

    private final BaseItemService baseItemService;


    @PostMapping(value = "/base-item")
    public CommonResponse createBaseItem(@Valid @RequestBody CreateBaseItemForm form,
                                         Principal principal) {

        String email = principal.getName();
        BaseItem baseItem = baseItemService.createBaseItem(email, form);

        return new CommonResponse(BaseItemDto.of(baseItem));
    }
}
