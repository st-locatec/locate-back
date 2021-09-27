package com.toolc.stmap.domain.product.exception;

public class NotExistProductException extends RuntimeException {
  private final static String MESSAGE = "해당 product가 존재하지 않습니다.";

  public NotExistProductException() {
    super(MESSAGE);
  }
}
