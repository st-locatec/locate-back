package com.toolc.stmap.domain.product.repository.interfaces;

import com.toolc.stmap.domain.product.entity.product.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
  Product save(Product productEntity);
  Optional<Product> findById(Long id);
  List<Product> findAllByIsRegister(Boolean isRegistered);
}
