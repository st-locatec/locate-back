package com.toolc.stmap.domain.product.api;

import com.toolc.stmap.domain.product.dto.ProductRegisterPermitDto;
import com.toolc.stmap.domain.product.dto.ProductRegisterRequestDto;
import com.toolc.stmap.domain.product.entity.product.Product;
import com.toolc.stmap.domain.product.service.PermittingProduct;
import com.toolc.stmap.domain.product.service.RegisteringProduct;
import com.toolc.stmap.global.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

  private final RegisteringProduct registeringProduct;
  private final PermittingProduct permittingProduct;

  //물건 등록 요청
  @PostMapping("/api/product/register/request")
  public ResponseEntity<?> register(@RequestBody ProductRegisterRequestDto dto) throws IOException {
    registeringProduct.register(
      dto.getLatitude(), dto.getLongitude(), dto.getType(), dto.getImage());

    SuccessResponse response = new SuccessResponse("등록 요청 성공");
    return ResponseEntity.ok().body(response);
  }

  @PostMapping("/api/product/register/permit")
  public ResponseEntity<?> permit(@RequestBody ProductRegisterPermitDto dto) {
    Product permitProduct = permittingProduct.permit(dto.getProductId());

    SuccessResponse response = new SuccessResponse(permitProduct);
    return ResponseEntity.ok().body(response);
  }

}

