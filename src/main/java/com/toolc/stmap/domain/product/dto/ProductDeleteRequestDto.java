package com.toolc.stmap.domain.product.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDeleteRequestDto {

  private Long productId;

  public ProductDeleteRequestDto(Long productId) {
    this.productId = productId;
  }
}
