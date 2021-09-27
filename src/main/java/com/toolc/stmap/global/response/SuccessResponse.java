package com.toolc.stmap.global.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SuccessResponse {
  private final int status = HttpStatus.OK.value();
  private final Object response;

  public SuccessResponse(Object response) {
    this.response = response;
  }
}
