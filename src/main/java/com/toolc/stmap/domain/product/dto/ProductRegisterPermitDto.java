package com.toolc.stmap.domain.product.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductRegisterPermitDto {

  private Long productId;

  public ProductRegisterPermitDto(Long productId) {
    this.productId = productId;
  }
}
