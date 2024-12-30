package com.springboot.advanced_jpa.repository;

import com.querydsl.core.types.Predicate;
import com.springboot.advanced_jpa.data.entity.Product;
import com.springboot.advanced_jpa.data.repository.QProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QProductRepositoryTest {

    @Autowired
    private QProductRepository qProductRepository;

    @Test
    public void queryDSLTest2() {
        QProduct qProduct = QProduct.product;

        Predicate predicate = qProduct.name.contains("펜")
                .and(qProduct.price.between(550, 1500));

        Iterable<Product> productList = qProductRepository.findAll(predicate);

        for (Product product : productList) {
            System.out.println("Product Number: " + product.getNumber());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product Price: " + product.getPrice());
            System.out.println("Product Stock: " + product.getStock());
        }
    }
}
