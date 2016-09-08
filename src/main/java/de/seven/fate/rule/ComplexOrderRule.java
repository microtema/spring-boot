package de.seven.fate.rule;

import de.seven.fate.entity.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

import static org.apache.commons.lang3.Validate.notNull;

@Component
@Scope(value = "prototype")
public class ComplexOrderRule extends SimpleOrderRule {

    @Override
    public boolean validate(Order order) {

        return super.validate(order); //&
    }
}
