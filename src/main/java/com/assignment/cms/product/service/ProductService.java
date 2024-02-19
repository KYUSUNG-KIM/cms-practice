package com.assignment.cms.product.service;

import com.assignment.cms.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final BaseItemService baseItemService;

    private final ProductRepository productRepository;


    @Transactional
    public void createProduct() {

    }



}
