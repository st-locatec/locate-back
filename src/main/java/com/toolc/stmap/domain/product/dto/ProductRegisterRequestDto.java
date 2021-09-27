package com.toolc.stmap.domain.product.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductRegisterRequestDto {

  private Double latitude;
  private Double longitude;
  private String type;
  private String image;

  public ProductRegisterRequestDto(Double latitude, Double longitude, String type, String image) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.type = type;
    this.image = image;
  }

}
