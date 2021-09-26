package com.toolc.stmap.domain.product.repository.interfaces;

import com.toolc.stmap.domain.product.entity.product.Product;

public interface ProductRepository {
  Product save(Product objectEntity);
}
