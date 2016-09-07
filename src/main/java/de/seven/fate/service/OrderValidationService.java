package de.seven.fate.service;

import de.seven.fate.entity.Order;

public interface OrderValidationService {

    boolean validate(Order order);
}
