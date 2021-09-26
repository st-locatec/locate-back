package com.toolc.stmap.domain.product.service;

import com.toolc.stmap.domain.product.repository.interfaces.ProductRepository;
import com.toolc.stmap.domain.product.vo.RegisteringRequestProductVo;
import com.toolc.stmap.global.common.s3.S3Uploader;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

import static java.util.Base64.getDecoder;

public interface RegisteringProduct {
  String register(Double latitude, Double longitude, String type, String image) throws IOException;

  @RequiredArgsConstructor
  class UpdateDatabase implements RegisteringProduct {

    private final ProductRepository productRepository;

    @Override
    public String register(Double latitude, Double longitude, String type, String image) {
      RegisteringRequestProductVo productVo = new RegisteringRequestProductVo(latitude, longitude, type, image);
      System.out.println("db");
      productRepository.save(productVo.parsingEntity());
      return null;
    }
  }

  @RequiredArgsConstructor
  class UploadS3 implements RegisteringProduct {

    private final S3Uploader s3Uploader;

    @Override
    public String register(Double latitude, Double longitude, String type, String image) throws IOException {
      String profileImg = s3Uploader.upload(getDecoder().decode(image), type);
      return profileImg;
    }
  }

  @RequiredArgsConstructor
  class Sequence implements RegisteringProduct {
    private final List<RegisteringProduct> registeringProducts;

    @Override
    public String register(Double latitude, Double longitude, String type, String image) throws IOException {
      String imageUrl = registeringProducts.get(0).register(latitude, longitude, type, image);
      registeringProducts.get(1).register(latitude, longitude, type, imageUrl);

      return null;
    }
  }



}
