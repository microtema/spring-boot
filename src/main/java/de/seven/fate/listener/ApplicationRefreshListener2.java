package de.seven.fate.listener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Annotation-driven event listener, automatically register an ApplicationListener matching the signature of the method
 */
@Component
public class ApplicationRefreshListener2 {

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(event);
    }
}
