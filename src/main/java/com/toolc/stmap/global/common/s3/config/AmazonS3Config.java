package com.toolc.stmap.global.common.s3.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.toolc.stmap.domain.object.repository.interfaces.ProductRepository;
import com.toolc.stmap.domain.object.service.RegisteringProduct;
import com.toolc.stmap.global.common.s3.S3Uploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class AmazonS3Config {

  @Value("${cloud.aws.credentials.access-key}")
  private String accessKey;

  @Value("${cloud.aws.credentials.secret-key}")
  private String secretKey;

  @Value("${cloud.aws.region.static}")
  private String region;

  @Bean
  public AmazonS3Client amazonS3Client() {
    BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
    return (AmazonS3Client) AmazonS3ClientBuilder.standard()
      .withRegion(region)
      .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
      .build();
  }

  @Autowired
  ProductRepository productRepository;

  @Autowired
  S3Uploader s3Uploader;

  @Bean
  public RegisteringProduct registeringProduct(){
    final RegisteringProduct s3 = new RegisteringProduct.UploadS3(s3Uploader);
    final RegisteringProduct db = new RegisteringProduct.UpdateDatabase(productRepository);

    return new RegisteringProduct.Sequence(Arrays.asList(s3, db));
  }
}
