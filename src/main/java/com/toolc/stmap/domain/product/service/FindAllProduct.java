package com.toolc.stmap.domain.product.service;

import com.toolc.stmap.domain.product.entity.product.Product;
import com.toolc.stmap.domain.product.repository.interfaces.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllProduct {

  private final ProductRepository productRepository;

  public List<Product> findAll() {
    List<Product> products = productRepository.findAll();
    return products;
  }
}
