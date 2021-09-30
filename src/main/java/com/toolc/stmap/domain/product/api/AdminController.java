package com.toolc.stmap.domain.product.api;

import com.toolc.stmap.domain.product.dto.ProcessingRegisterRequestDto;
import com.toolc.stmap.domain.product.dto.ProductRegisterRequestDto;
import com.toolc.stmap.domain.product.entity.product.Product;
import com.toolc.stmap.domain.product.service.InquiryProduct;
import com.toolc.stmap.domain.product.service.ProcessingRegisterRequestProduct;
import com.toolc.stmap.domain.product.service.RegisteringProduct;
import com.toolc.stmap.global.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AdminController {

  private final InquiryProduct inquiryProduct;
  private final ProcessingRegisterRequestProduct processingRegisterRequestProduct;
  private final RegisteringProduct registeringProduct;


  @GetMapping("/api/admin/find/registered")
  public ResponseEntity<?> getRegistered() {

    List<Product> products = inquiryProduct.inquiry(true);
    if(products.isEmpty()){
      return ResponseEntity.ok().body(new SuccessResponse("product가 없습니다."));
    }

    return ResponseEntity.ok().body(new SuccessResponse(products));
  }

  @GetMapping("/api/admin/find/NotRegistered")
  public ResponseEntity<?> getNotRegistered() {

    List<Product> products = inquiryProduct.inquiry(false);
    if(products.isEmpty()){
      return ResponseEntity.ok().body(new SuccessResponse("product가 없습니다."));
    }

    return ResponseEntity.ok().body(new SuccessResponse(products));
  }

  @PostMapping("/api/admin/register")
  public ResponseEntity<?> register(@RequestBody ProductRegisterRequestDto dto) throws IOException {
    registeringProduct.register(
      dto.getLatitude(), dto.getLongitude(), dto.getType(), dto.getImage(), true);

    SuccessResponse response = new SuccessResponse("관리자 권한으로 product 등록 성공");
    return ResponseEntity.ok().body(response);
  }

  @PostMapping("/api/admin/register/permit")
  public ResponseEntity<?> permit(@RequestBody ProcessingRegisterRequestDto dto) {
    Product permitProduct = processingRegisterRequestProduct.permit(dto.getProductId());

    SuccessResponse response = new SuccessResponse(permitProduct);
    return ResponseEntity.ok().body(response);
  }

  @PostMapping("/api/admin/register/reject")
  public ResponseEntity<?> reject(@RequestBody ProcessingRegisterRequestDto dto) {
    processingRegisterRequestProduct.reject(dto.getProductId());

    SuccessResponse response = new SuccessResponse("요청 거절 성공");
    return ResponseEntity.ok().body(response);
  }


}
