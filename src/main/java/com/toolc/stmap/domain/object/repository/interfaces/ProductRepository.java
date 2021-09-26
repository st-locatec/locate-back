package com.toolc.stmap.domain.object.repository.interfaces;

import com.toolc.stmap.domain.object.entity.product.Product;

public interface ProductRepository {
  Product save(Product objectEntity);
}
