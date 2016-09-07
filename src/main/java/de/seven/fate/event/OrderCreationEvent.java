package de.seven.fate.event;

import de.seven.fate.entity.Order;

public class OrderCreationEvent extends CreationEvent<Order> {

    public OrderCreationEvent(final Order source) {
        super(source);
    }
}
