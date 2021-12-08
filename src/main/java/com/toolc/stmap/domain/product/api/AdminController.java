package com.toolc.stmap.domain.product.api;

import com.toolc.stmap.domain.product.dto.*;
import com.toolc.stmap.domain.product.entity.product.Product;
import com.toolc.stmap.domain.product.service.*;
import com.toolc.stmap.global.response.BadRequestResponse;
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
@RequestMapping("/api/admin")
public class AdminController {

  private final InquiryProduct inquiryProduct;
  private final ProcessingRegisterRequestProduct processingRegisterRequestProduct;
  private final RegisteringProduct registeringProduct;
  private final ChangeProduct changeProduct;
  private final DeleteProduct deleteProduct;
  private final AdminLogin adminLogin;
  private final FindAllProduct findAllProduct;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody AdminLoginDto dto) {

    if(adminLogin.login(dto.getId(), dto.getPassword())){
      return ResponseEntity.ok(new SuccessResponse("Login 성공"));
    }

    return ResponseEntity.badRequest().body(new BadRequestResponse("Login 실패"));
  }

  @GetMapping("/find/NotRegistered")
  public ResponseEntity<?> getNotRegistered() {

    List<Product> products = inquiryProduct.inquiry(false);
    if (products.isEmpty()) {
      return ResponseEntity.ok().body(new SuccessResponse("product가 없습니다."));
    }

    return ResponseEntity.ok().body(new SuccessResponse(products));
  }

  @GetMapping("/find/all")
  public ResponseEntity<?> findAllProduct() throws IOException {
    List<Product> products = findAllProduct.findAll();

    if (products.isEmpty()) {
      return ResponseEntity.ok().body(new SuccessResponse("product가 없습니다."));
    }
    return ResponseEntity.ok().body(new SuccessResponse(products));
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody ProductRegisterRequestDto dto) throws IOException {
    registeringProduct.register(
      dto.getLatitude(), dto.getLongitude(), dto.getType(), dto.getImage(),
      true);

    SuccessResponse response = new SuccessResponse("관리자 권한으로 product 등록 성공");
    return ResponseEntity.ok().body(response);
  }

  @PostMapping("/change")
  public ResponseEntity<?> change(@RequestBody ProductChangeRequestDto dto) throws IOException {
    changeProduct.change(dto.getProductId(), dto.getLatitude(),
      dto.getLongitude(), dto.getType(), dto.getImage());

    SuccessResponse response = new SuccessResponse("수정 성공 ");
    return ResponseEntity.ok().body(response);
  }

  @PostMapping("/delete")
  public ResponseEntity<?> delete(@RequestBody ProductDeleteRequestDto dto) {
    deleteProduct.delete(dto.getProductId());

    SuccessResponse response = new SuccessResponse("삭제 성공");
    return ResponseEntity.ok().body(response);
  }

  @PostMapping("/register/permit")
  public ResponseEntity<?> permit(@RequestBody ProcessingRegisterRequestDto dto) {
    Product permitProduct =
      processingRegisterRequestProduct.permit(dto.getProductId());

    SuccessResponse response = new SuccessResponse(permitProduct);
    return ResponseEntity.ok().body(response);
  }

  @PostMapping("/register/reject")
  public ResponseEntity<?> reject(@RequestBody ProcessingRegisterRequestDto dto) {
    processingRegisterRequestProduct.reject(dto.getProductId());

    SuccessResponse response = new SuccessResponse("요청 거절 성공");
    return ResponseEntity.ok().body(response);
  }


}
