package com.springboot.advanced_jpa.data.repository.support;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.advanced_jpa.data.entity.Product;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public ProductRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Product.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Product> findByName(String name) {
        QProduct product = QProduct.product;

        return jpaQueryFactory
                .selectFrom(product)
                .where(product.name.eq(name))
                .fetch();
    }
}
