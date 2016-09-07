package de.seven.fate.rule;

import de.seven.fate.entity.Order;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.Validate.notNull;

@Component
public class SimpleOrderRule implements OrderRule {

    @Override
    public boolean validate(Order order) {
        notNull(order);

        return order.isDone();
    }
}
