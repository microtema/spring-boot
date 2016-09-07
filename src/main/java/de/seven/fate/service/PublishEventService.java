package de.seven.fate.service;

import de.seven.fate.entity.Order;
import de.seven.fate.event.CreationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Lazy(value = false)
public class PublishEventService {

    private final ApplicationEventPublisher publisher;

    @Autowired
    public PublishEventService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishEvent(Order order) {
        publisher.publishEvent(new CreationEvent(order));
    }

}
