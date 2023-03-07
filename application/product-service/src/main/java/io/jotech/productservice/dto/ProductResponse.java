package io.jotech.productservice.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

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
public class ProductResponse {
    private BigInteger id;
    private String name;
    private String description;
    private BigDecimal price;

}
