package com.assignment.cms.product.repository;

import com.assignment.cms.product.entity.ProductDetail;
import com.assignment.cms.product.entity.ProductDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, ProductDetailId> {
}
