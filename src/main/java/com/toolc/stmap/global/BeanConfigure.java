package com.toolc.stmap.global;

import com.toolc.stmap.domain.product.repository.interfaces.ProductRepository;
import com.toolc.stmap.domain.product.service.RegisteringProduct;
import com.toolc.stmap.global.common.s3.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class BeanConfigure {

  private final ProductRepository productRepository;
  private final  S3Uploader s3Uploader;

  @Bean
  public RegisteringProduct registeringProduct(){
    final RegisteringProduct s3 = new RegisteringProduct.UploadS3(s3Uploader);
    final RegisteringProduct db = new RegisteringProduct.UpdateDatabase(productRepository);

    return new RegisteringProduct.Sequence(Arrays.asList(s3, db));
  }
}
