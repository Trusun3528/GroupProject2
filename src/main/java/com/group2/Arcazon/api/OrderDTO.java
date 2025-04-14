package com.group2.Arcazon.api;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private Long customerId;
    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO() {}

    public OrderDTO(Long customerId, List<OrderItemDTO> items) {
        this.customerId = customerId;
        this.items = items;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
