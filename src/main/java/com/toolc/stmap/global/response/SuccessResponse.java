package com.toolc.stmap.global.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SuccessResponse {
  private final int status = HttpStatus.OK.value();
  private final String message;

  public SuccessResponse(String message) {
    this.message = message;
  }
}
