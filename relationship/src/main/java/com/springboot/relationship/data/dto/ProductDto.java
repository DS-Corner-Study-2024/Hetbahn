package com.springboot.relationship.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDto {
    @Schema(
            description = "상품 이름",
            example = "삼성 노트북"
    )
    @NotBlank(message = "상품 이름은 필수 입력 값입니다.")
    private String name;

    @Schema(
            description = "상품 가격 (원화 기준)",
            example = "1000000"
    )
    @NotNull(message = "상품 가격은 필수 입력 값입니다.")
    @Min(value = 1, message = "상품 가격은 1원 이상이어야 합니다.")
    private int price;

    @Schema(
            description = "재고 수량",
            example = "100"
    )
    @NotNull(message = "재고 수량은 필수 입력 값입니다.")
    @Min(value = 0, message = "재고 수량은 0 이상이어야 합니다.")
    private int stock;

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
