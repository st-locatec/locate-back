package com.toolc.stmap.domain.product.api;

import com.toolc.stmap.domain.product.dto.ProductRegisterRequestDto;
import com.toolc.stmap.domain.product.entity.product.Product;
import com.toolc.stmap.domain.product.service.InquiryProduct;
import com.toolc.stmap.domain.product.service.RegisteringProduct;
import com.toolc.stmap.global.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

  private final RegisteringProduct registeringProduct;
  private final InquiryProduct inquiryProduct;

  //물건 등록 요청
  @PostMapping("/register/request")
  public ResponseEntity<?> register(@RequestBody ProductRegisterRequestDto dto) throws IOException {
    registeringProduct.register(
      dto.getLatitude(), dto.getLongitude(), dto.getType(), dto.getImage(), false);

    SuccessResponse response = new SuccessResponse("등록 요청 성공");
    return ResponseEntity.ok().body(response);
  }

  @GetMapping("/find/registered")
  public ResponseEntity<?> getRegistered() {

    List<Product> products = inquiryProduct.inquiry(true);
    if(products.isEmpty()){
      return ResponseEntity.ok().body(new SuccessResponse("product가 없습니다."));
    }

    return ResponseEntity.ok().body(new SuccessResponse(products));
  }





}

