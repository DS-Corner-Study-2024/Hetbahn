package com.springboot.advanced_jpa.repository;

import com.springboot.advanced_jpa.data.entity.Product;
import com.springboot.advanced_jpa.data.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void sortingAndPagingTest() {
        // 데이터 준비
        Product product1 = new Product();
        product1.setName("펜");
        product1.setPrice(1000);
        product1.setStock(100);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("펜");
        product2.setPrice(500);
        product2.setStock(200);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Product product3 = new Product();
        product3.setName("펜");
        product3.setPrice(1500);
        product3.setStock(50);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdatedAt(LocalDateTime.now());

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        // 정렬 조건에 따라 데이터 조회
        List<Product> sortedProducts = productRepository.findByName("펜", getSort());

        // 쿼리 결과 출력
        sortedProducts.forEach(System.out::println);
    }

    // 정렬 조건을 반환하는 메서드
    private Sort getSort() {
        return Sort.by(
                Order.asc("price"), // price 기준 오름차순 정렬
                Order.desc("stock") // stock 기준 내림차순 정렬
        );
    }
}
