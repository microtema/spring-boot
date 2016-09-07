package de.seven.fate.listener;

import de.seven.fate.entity.Order;
import de.seven.fate.event.CreationEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderEventListener{
    
    @EventListener(condition = "#event.order.done")
    public void onCreationOrderEvent(CreationEvent event) {
        System.out.println(event);
    }
}
