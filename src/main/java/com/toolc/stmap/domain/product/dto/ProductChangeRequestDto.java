package com.toolc.stmap.domain.product.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductChangeRequestDto {

  private Long productId;
  private Double latitude;
  private Double longitude;
  private String type;
  private String image;

  public ProductChangeRequestDto(Long productId, Double latitude, Double longitude, String type, String image) {
    this.productId = productId;
    this.latitude = latitude;
    this.longitude = longitude;
    this.type = type;
    this.image = image;
  }

}
