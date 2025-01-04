package com.springboot.relationship.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToOne(optional = false)
    @JoinColumn(name = "product_number", nullable = false)
    private Product product;
}

