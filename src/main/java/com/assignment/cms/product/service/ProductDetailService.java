package com.assignment.cms.product.service;

import com.assignment.cms.product.entity.ProductDetail;
import com.assignment.cms.product.repository.ProductDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductDetailService {

    private final ProductDetailRepository productDetailRepository;


    @Transactional
    public void save(long productId, long itemId, int quantity) {

        productDetailRepository.save(new ProductDetail(productId, itemId, quantity));
    }
}
