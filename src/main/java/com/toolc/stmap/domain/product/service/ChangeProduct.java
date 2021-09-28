package com.toolc.stmap.domain.product.service;

import com.toolc.stmap.domain.product.entity.product.Product;
import com.toolc.stmap.domain.product.exception.NotExistProductException;
import com.toolc.stmap.domain.product.repository.interfaces.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChangeProduct {

  private final ProductRepository productRepository;
  private final RegisteringProduct registeringProduct;

  public void change(Long productId, Double latitude, Double longitude, String type, String image) throws IOException {
    Product deleteProduct = productRepository.findById(productId).orElseThrow(NotExistProductException::new);
    productRepository.delete(deleteProduct);
    registeringProduct.register(latitude, longitude, type, image);
  }
}
