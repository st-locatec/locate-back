package com.toolc.stmap.domain.product.entity.product;

import com.toolc.stmap.global.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    private String latitude;

    private String longitude;

    @Enumerated(value = EnumType.STRING)
    private LocationType type;

    private String ImageUrl;

    private Boolean isRegister;
  public Product(String latitude, String longitude, LocationType type, String imageUrl, Boolean isRegister) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.type = type;
    ImageUrl = imageUrl;
    this.isRegister = isRegister;
  }

  public void changeStatusProduct(Boolean status){
    this.isRegister = status;
  }
}
