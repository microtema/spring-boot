package de.seven.fate.service;

import de.seven.fate.entity.Order;
import de.seven.fate.rule.ComplexOrderRule;
import de.seven.fate.rule.OrderRule;
import de.seven.fate.rule.SimpleOrderRule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OrderValidationService.class, OrderValidationServiceImpl.class, OrderRule.class, SimpleOrderRule.class, ComplexOrderRule.class})
public class OrderValidationServiceImplTest {

    @Autowired
    private OrderValidationService sut;

    @Test
    public void validate() throws Exception {
        Assert.assertFalse(sut.validate(new Order()));
    }

}