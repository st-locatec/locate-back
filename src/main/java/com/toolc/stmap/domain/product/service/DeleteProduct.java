package com.toolc.stmap.domain.product.service;

import com.toolc.stmap.domain.product.entity.product.Product;
import com.toolc.stmap.domain.product.exception.NotExistProductException;
import com.toolc.stmap.domain.product.repository.interfaces.ProductRepository;
import com.toolc.stmap.domain.product.vo.RegisteringRequestProductVo;
import com.toolc.stmap.global.common.s3.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static java.util.Base64.getDecoder;

@Service
@RequiredArgsConstructor
public class DeleteProduct {

  private final ProductRepository productRepository;

  public void delete(Long productId){

    Product deleteProduct = productRepository.findById(productId).orElseThrow(NotExistProductException::new);
    productRepository.delete(deleteProduct);
  }


}
