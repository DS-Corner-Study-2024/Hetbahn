package com.springboot.jpa.data.dao.impl;

import com.springboot.jpa.data.dao.ProductDAO;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component // 스프링 빈 등록
public class ProductDAOImpl implements ProductDAO {

    // DAO 객체가 DB에 접근하기 위해 리포지토리 인터페이스를 사용해 의존성을 주입 받음
    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    // 인터페이스를 정의한 메서드 구현
    @Override
    public Product insertProduct(Product product) {  // Product 엔티티를 DB에 저장
        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    @Override
    public Product selectProduct(Long number) { // 조회 메서드
        Product savedProduct = productRepository.getById(number);

        return savedProduct;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception { // 상품명 업데이트
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updatedProduct;
        if(selectedProduct.isPresent()){
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdateAt(LocalDateTime.now());

            updatedProduct = productRepository.save(product);
        } else{
            throw new Exception();
        }

        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {  // 삭제 메서드
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()){
            Product product = selectedProduct.get();
            productRepository.delete(product);
        } else{
            throw new Exception();
        }

    }
}