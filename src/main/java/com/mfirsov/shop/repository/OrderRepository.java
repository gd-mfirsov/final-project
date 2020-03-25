package com.mfirsov.shop.repository;

import com.mfirsov.shop.model.ProductOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<ProductOrder, Long> {

}
