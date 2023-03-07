package io.jotech.orderservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import io.jotech.orderservice.dto.InventoryResponse;
import io.jotech.orderservice.dto.OrderLineItemDto;
import io.jotech.orderservice.dto.OrderRequest;
import io.jotech.orderservice.event.OrderPlacedEvent;
import io.jotech.orderservice.model.Order;
import io.jotech.orderservice.model.OrderLineItem;
import io.jotech.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    private final WebClient.Builder webClientBuilder;
    private final KafkaTemplate<String,OrderPlacedEvent> kafkaTemplate;

    public String placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItemList(orderRequest.getOrderLineItemRequests()
                .stream()
                .map(this::mapToOrderLineItem).toList());
        //TODO: Call Inventory service to and proceed to make the order
        List<String> skuCodes = order.getOrderLineItemList().stream().map(OrderLineItem::getSkuCode).toList();
        InventoryResponse[] inventoryResponses = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",

                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes)
                                .build())

                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
        if (inventoryResponses != null) {
            boolean inStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::getInStock);
            if (Boolean.TRUE.equals(inStock)) {
                orderRepository.save(order);
                kafkaTemplate.send("notificationTopic",new OrderPlacedEvent(order.getOrderNumber()));
                return "Order placed successfully";
            }
        }
        throw new IllegalArgumentException("Product is not in stock");

    }

    private OrderLineItem mapToOrderLineItem(OrderLineItemDto orderLineItemDto) {
        var mapper = new ModelMapper();
        return mapper.map(orderLineItemDto, OrderLineItem.class);

    }
}
