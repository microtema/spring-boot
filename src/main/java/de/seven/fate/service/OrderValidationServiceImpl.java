package de.seven.fate.service;

import de.seven.fate.entity.Order;
import de.seven.fate.rule.OrderRule;

import java.util.Set;

public class OrderValidationServiceImpl implements OrderValidationService {

    private final Set<OrderRule> orderRules;

    public OrderValidationServiceImpl(Set<OrderRule> orderRules) {
        this.orderRules = orderRules;
    }

    @Override
    public boolean validate(Order order) {

        return !orderRules.stream().filter(orderRule -> !orderRule.validate(order)).findAny().isPresent();
    }
}
