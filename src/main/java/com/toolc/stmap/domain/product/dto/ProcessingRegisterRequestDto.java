package com.toolc.stmap.domain.product.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProcessingRegisterRequestDto {

  private Long productId;

  public ProcessingRegisterRequestDto(Long productId) {
    this.productId = productId;
  }
}
