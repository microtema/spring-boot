package de.seven.fate.rule;

import de.seven.fate.entity.Order;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimpleOrderRuleTest {

    private OrderRule sut = new SimpleOrderRule();

    private Order order = new Order();

    @Test(expected = NullPointerException.class)
    public void validate() {
        sut.validate(null);
    }

    @Test
    public void shouldBeInvalid() {

        //when
        order.setDone(false);

        //then
        assertFalse(sut.validate(order));
    }

    @Test
    public void shouldBeValid() {

        //when
        order.setDone(true);

        //then
        assertTrue(sut.validate(order));
    }

}