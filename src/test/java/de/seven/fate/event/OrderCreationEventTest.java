package de.seven.fate.event;

import de.seven.fate.entity.Order;
import org.junit.Assert;
import org.junit.Test;

public class OrderCreationEventTest {

    private CreationEvent<Order> sut = new OrderCreationEvent(new Order());

    @Test
    public void genericType() {
        Assert.assertSame(Order.class, sut.getGenericType());
    }
}