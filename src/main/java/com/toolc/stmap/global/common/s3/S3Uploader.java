package com.toolc.stmap.global.common.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class S3Uploader {

  private final AmazonS3Client amazonS3Client;

  @Value("${cloud.aws.s3.bucket}")
  public String bucket;  // S3 버킷 이름

  public String upload(byte[] multipartFile, String dirName) throws IOException {
    String fileName = dirName + "/" + UUID.randomUUID() + ".png";
    amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, new ByteArrayInputStream(multipartFile), null)
      .withCannedAcl(CannedAccessControlList.PublicRead));
    return amazonS3Client.getUrl(bucket, fileName).toString();
  }

}
