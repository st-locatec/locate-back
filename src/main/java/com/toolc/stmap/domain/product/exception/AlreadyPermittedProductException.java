package com.toolc.stmap.domain.product.exception;

public class AlreadyPermittedProductException extends RuntimeException {
  private final static String MESSAGE = "이미 등록 허가된 product 입니다.";

  public AlreadyPermittedProductException() {
    super(MESSAGE);
  }
}
