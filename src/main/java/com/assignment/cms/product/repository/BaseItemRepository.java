package com.assignment.cms.product.repository;

import com.assignment.cms.product.entity.BaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseItemRepository extends JpaRepository<BaseItem, Long> {
}
