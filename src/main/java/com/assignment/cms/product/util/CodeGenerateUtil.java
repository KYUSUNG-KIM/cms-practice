package com.assignment.cms.product.util;

import com.assignment.cms.product.constants.ItemCategory;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class CodeGenerateUtil {



    // 베이스 아이템 재고번호(sku)
    // 카테고리 코드 앞 2자리 + 랜덤코드 6자리
    public String generateSku(ItemCategory itemCategory) {

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        uuid = uuid.substring(0, 6).toUpperCase();

        return itemCategory.name().substring(0, 2).toUpperCase() + uuid;

    }


    // 상품 코드
    // P + yyyyMMdd + 랜덤코드 6자리
    private String generateProductCode() {

        String forwardWord = "P";
        String ymd = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String randomStringValue = RandomStringUtils.randomAlphanumeric(6).toUpperCase();

        return forwardWord + ymd + randomStringValue;
    }

}
