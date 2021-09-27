package com.toolc.stmap.domain.product.service;

import com.toolc.stmap.domain.product.entity.product.Product;
import com.toolc.stmap.domain.product.exception.NotExistProductException;
import com.toolc.stmap.domain.product.repository.interfaces.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InquiryProduct {

  private final ProductRepository productRepository;

  public List<Product> inquiry(Boolean registered) {
    List<Product> products = productRepository.findAllByIsRegister(registered);
    return products;
  }
}
