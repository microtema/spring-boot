package de.seven.fate.event;

import de.seven.fate.entity.Order;

public class CreationEvent {

    private final Order order;

    public CreationEvent(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
