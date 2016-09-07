package de.seven.fate.rule;

import de.seven.fate.entity.Order;

public interface OrderRule {

    boolean validate(Order order);
}
