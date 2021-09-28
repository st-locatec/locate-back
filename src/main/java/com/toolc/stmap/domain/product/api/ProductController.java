package com.toolc.stmap.domain.product.api;

import com.toolc.stmap.domain.product.dto.ProductRegisterRequestDto;
import com.toolc.stmap.domain.product.entity.product.Product;
import com.toolc.stmap.domain.product.service.FindAllProduct;
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
public class ProductController {

  private final RegisteringProduct registeringProduct;
  private final FindAllProduct findAllProduct;

  //물건 등록 요청
  @PostMapping("/api/product/register/request")
  public ResponseEntity<?> register(@RequestBody ProductRegisterRequestDto dto) throws IOException {
    registeringProduct.register(
      dto.getLatitude(), dto.getLongitude(), dto.getType(), dto.getImage());

    SuccessResponse response = new SuccessResponse("등록 요청 성공");
    return ResponseEntity.ok().body(response);
  }

  @GetMapping("/api/product/all")
  public ResponseEntity<?> findAllProduct() throws IOException {
    List<Product> products = findAllProduct.findAll();

    if(products.isEmpty()){
      return ResponseEntity.ok().body(new SuccessResponse("product가 없습니다."));
    }
    return ResponseEntity.ok().body(new SuccessResponse(products));
  }


}

