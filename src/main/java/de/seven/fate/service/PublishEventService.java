package de.seven.fate.service;

import de.seven.fate.entity.Order;
import de.seven.fate.event.CreationEvent;
import de.seven.fate.rule.OrderRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PublishEventService {

    //Constructor Dependency
    private final ApplicationEventPublisher publisher;

    //Field Dependency
    @Autowired
    private OrderRule simpleOrderRule;

    //Setter Dependency
    private OrderValidationServiceImpl complexOrderValidationService;

    public PublishEventService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishEvent(Order order) {
        publisher.publishEvent(new CreationEvent(order));
    }

    @PostConstruct
    private void init() {
        System.out.println(this);
    }


    public void setComplexOrderValidationService(OrderValidationServiceImpl complexOrderValidationService) {
        this.complexOrderValidationService = complexOrderValidationService;
    }
}
