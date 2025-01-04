package com.springboot.relationship.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductResponseDto {
    @Schema(
            description = "상품 고유 번호",
            example = "1"
    )
    @NotNull
    private Long number;

    @Schema(
            description = "상품 이름",
            example = "갤럭시 노트북"
    )
    @NotBlank
    private String name;

    @Schema(
            description = "상품 가격 (원)",
            example = "1200000"
    )
    @NotNull
    private int price;

    @Schema(
            description = "재고 수량",
            example = "50"
    )
    @NotNull
    private int stock;

    // Getter and Setter for number
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for price
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Getter and Setter for stock
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductResponseDto{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
