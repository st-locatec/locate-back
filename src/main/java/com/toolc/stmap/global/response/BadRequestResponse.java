package com.toolc.stmap.global.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BadRequestResponse {
  private final int status = HttpStatus.BAD_REQUEST.value();
  private final String message;

  public BadRequestResponse(String message) {
    this.message = message;
  }
}
