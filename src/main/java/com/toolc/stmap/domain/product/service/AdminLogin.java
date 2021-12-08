package com.toolc.stmap.domain.product.service;


import org.springframework.stereotype.Service;

@Service
public class AdminLogin {

  public boolean login(String id, String password) {
    if(id.equals("admin@google.com") && password.equals("qwer1234!"))
      return true;
    return false;
  }
}
