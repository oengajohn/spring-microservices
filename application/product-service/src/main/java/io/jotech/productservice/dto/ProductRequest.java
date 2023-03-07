package io.jotech.productservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;

}
