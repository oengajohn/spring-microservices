package io.jotech.orderservice.dto;

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
public class OrderLineItemDto {

    private BigInteger id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
