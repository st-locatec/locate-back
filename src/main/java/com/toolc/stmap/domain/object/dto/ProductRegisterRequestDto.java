package com.toolc.stmap.domain.object.dto;


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
//enum LocationType {
//  SMOKING, TRASH;
//
//
//  @JsonValue
//  private String type;
//
//
//
//  public String getType() {
//    return this.type;
//  }
//
//  @JsonCreator
//  public static LocationType getLocationType(String value) {
//    for (LocationType type : LocationType.values()) {
//      System.out.println(type);
//      if(type.getType().equals(value)){
//        return type;
//      }
//    }
//    return null;
//  }
//}