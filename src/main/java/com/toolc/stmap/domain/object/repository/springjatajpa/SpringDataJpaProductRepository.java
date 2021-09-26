package com.toolc.stmap.domain.object.repository.springjatajpa;

import com.toolc.stmap.domain.object.entity.product.Product;
import com.toolc.stmap.domain.object.repository.interfaces.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataJpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {
}
