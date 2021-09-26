package com.toolc.stmap.global;

import com.toolc.stmap.global.response.BadRequestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {
  @ExceptionHandler(value = {
    Contracts.ContractViolationException.class
  })
  public ResponseEntity<?> badRequest(Exception e) {
//    BadRequestResponse badRequestResponse = new BadRequestResponse(e.getMessage());
    return ResponseEntity.badRequest().body( new BadRequestResponse(e.getMessage()));
  }
}
