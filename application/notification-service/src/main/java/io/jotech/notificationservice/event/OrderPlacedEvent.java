package io.jotech.notificationservice.event;

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
public class OrderPlacedEvent {
    private String orderNumber;
}
