package com.toolc.stmap.domain.product.repository.springjatajpa;

import com.toolc.stmap.domain.product.entity.product.Product;
import com.toolc.stmap.domain.product.repository.interfaces.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataJpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {
}
