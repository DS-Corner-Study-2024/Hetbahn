package com.springboot.relationship.data.repository;

import com.springboot.relationship.data.entity.Producer;
import com.springboot.relationship.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ProducerRepositoryTest {

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    void relationshipTest2() {
        Product product1 = saveProduct("둥근펜", 500, 1000);
        Product product2 = saveProduct("네모 공책", 1000, 2000);
        Product product3 = saveProduct("지우개", 152, 1234);

        Producer producer1 = saveProducer("flature");
        Producer producer2 = saveProducer("wikibooks");

        producer1.addProduct(product1);
        producer1.addProduct(product2);

        producer2.addProduct(product2);
        producer2.addProduct(product3);

        product1.addProducer(producer1);
        product2.addProducer(producer1);
        product2.addProducer(producer2);
        product3.addProducer(producer2);

        producerRepository.save(producer1);
        producerRepository.save(producer2);

        System.out.println(producerRepository.findAll());
    }

    private Product saveProduct(String name, Integer price, Integer stock) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        return productRepository.save(product);
    }

    private Producer saveProducer(String name) {
        Producer producer = new Producer();
        producer.setName(name);
        return producerRepository.save(producer);
    }
}
