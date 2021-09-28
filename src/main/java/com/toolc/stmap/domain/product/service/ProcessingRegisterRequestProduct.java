package com.toolc.stmap.domain.product.service;

import com.toolc.stmap.domain.product.entity.product.Product;
import com.toolc.stmap.domain.product.exception.AlreadyPermittedProductException;
import com.toolc.stmap.domain.product.exception.NotExistProductException;
import com.toolc.stmap.domain.product.repository.interfaces.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.toolc.stmap.global.Contracts.requires;

@Service
@RequiredArgsConstructor
public class ProcessingRegisterRequestProduct {

  private final ProductRepository productRepository;

  public Product permit(Long productId) {
    Product product = productRepository.findById(productId).orElseThrow(NotExistProductException::new);
    product.changeStatusProduct(true);
    productRepository.save(product);
    return product;
  }

  public void reject(Long productId) {
    Product product = productRepository.findById(productId).orElseThrow(NotExistProductException::new);

    if(product.getIsRegister()){
      throw new AlreadyPermittedProductException();
    }

    productRepository.delete(product);
  }
}
