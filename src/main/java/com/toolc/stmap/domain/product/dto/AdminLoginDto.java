package com.toolc.stmap.domain.product.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdminLoginDto {

  private String id;
  private String password;

  public AdminLoginDto(String id, String password) {
    this.id = id;
    this.password = password;
  }
}
