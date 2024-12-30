package com.springboot.advanced_jpa.data.repository;

import com.springboot.advanced_jpa.data.entity.Product;
import org.springframework.data.domain.Sort; // 올바른 Sort import
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 엔티티에 대한 interface 생성, JpaRepository 상속 받음. (대상 엔티티와 ID의 타입 지정)
// JpaRepository에서 findAll() 등 많은 기능 제공.
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name, Sort sort);
}
