package com.toolc.stmap.domain.product.service;

import com.toolc.stmap.domain.product.entity.product.Product;
import com.toolc.stmap.domain.product.exception.NotExistProductException;
import com.toolc.stmap.domain.product.repository.interfaces.ProductRepository;
import com.toolc.stmap.domain.product.vo.RegisteringRequestProductVo;
import com.toolc.stmap.global.common.s3.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static java.util.Base64.getDecoder;

@Service
@RequiredArgsConstructor
public class ChangeProduct {

  private final ProductRepository productRepository;
  private final S3Uploader s3Uploader;

  public void change(Long productId, Double latitude, Double longitude, String type, String image) throws IOException {
    Product targetProduct = productRepository.findById(productId).orElseThrow(NotExistProductException::new);
    Product changeProduct = changeExcludeImage(targetProduct, latitude, longitude, type);
    if(image != null){
      changeImageUrl(type, image, changeProduct);
    }

    productRepository.save(changeProduct);

  }

  private void changeImageUrl(String type, String image, Product changeProduct) throws IOException {
    String profileImg = s3Uploader.upload(getDecoder().decode(image), type);
    changeProduct.setImageUrl(profileImg);
  }

  private Product changeExcludeImage(Product product, Double latitude, Double longitude, String type) {
    RegisteringRequestProductVo productVo = new RegisteringRequestProductVo(latitude, longitude, type, null);
    product.setLatitude(productVo.parsingEntity(false).getLatitude());
    product.setLongitude(productVo.parsingEntity(false).getLongitude());
    product.setType(productVo.parsingEntity(false).getType());

    return product;
  }
}
