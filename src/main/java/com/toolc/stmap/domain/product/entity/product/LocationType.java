package com.toolc.stmap.domain.product.entity.product;

public enum LocationType {
  smoking, trash;

  public static LocationType findBy(String type) {
    try {
      return valueOf(type);
    }catch (Exception e) {
      return null;
    }
  }
}
