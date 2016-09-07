package de.seven.fate.listener;

import de.seven.fate.event.CreationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderEventListener{

    @EventListener(condition = "#event.sourceObject.done")
    public void onCreationOrderEvent(CreationEvent event) {
        System.out.println(event);
    }
}
