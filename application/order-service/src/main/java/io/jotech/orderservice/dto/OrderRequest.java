package io.jotech.orderservice.dto;

import java.util.List;

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
public class OrderRequest {
    private List<OrderLineItemDto> orderLineItemRequests;
}
