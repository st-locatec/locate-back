package com.toolc.stmap.domain.product.vo;

import com.toolc.stmap.domain.product.entity.product.LocationType;
import com.toolc.stmap.domain.product.entity.product.Product;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import static com.toolc.stmap.global.Contracts.requires;

public class RegisteringRequestProductVo {

  private Address address;
  @Enumerated(value = EnumType.STRING)
  private LocationType type;

  private String imageUrl;


  class Address {
    private String latitude;
    private String longitude;

    //주소가 유효한가 검증
    public Address(Double latitude, Double longitude) {
      requires(37 < latitude && latitude < 38);
      requires(127 < longitude && longitude < 128);

      this.latitude = String.valueOf(latitude);
      this.longitude = String.valueOf(longitude);
    }
  }



  public RegisteringRequestProductVo(Double latitude, Double longitude, String type, String image) {
    //유효한 타입의 물건인지 검증
    requires(LocationType.findBy(type) != null);

    address = new Address(latitude,longitude);
    this.type = LocationType.valueOf(type);
    this.imageUrl = image;
  }

  //유효한 물건 Entity 파싱
  public Product parsingEntity(Boolean isRegister){
    return new Product(this.address.latitude, this.address.longitude, this.type, this.imageUrl, isRegister);
  }
}