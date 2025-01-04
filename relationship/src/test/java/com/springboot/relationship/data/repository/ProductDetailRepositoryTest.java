package com.springboot.relationship.data.repository;

import com.springboot.relationship.data.entity.Product;
import com.springboot.relationship.data.entity.ProductDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductDetailRepositoryTest {

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void saveAndReadTest() {
        // Product 엔티티 생성 및 저장
        Product product = new Product();
        product.setName("Spring Boot JPA");
        product.setPrice(1000);
        product.setStock(10);
        productRepository.save(product);

        // ProductDetail 엔티티 생성 및 저장
        ProductDetail productDetail = new ProductDetail();
        productDetail.setDescription("Spring Boot JPA with ProductDetail");
        productDetail.setProduct(product);  // Product와 연결
        productDetailRepository.save(productDetail);

        // 저장된 데이터 확인
        System.out.println("savedProductDetail : " +
                productDetailRepository.findById(productDetail.getId()).get());
    }
}
