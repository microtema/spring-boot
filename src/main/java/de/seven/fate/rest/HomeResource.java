package de.seven.fate.rest;

import de.seven.fate.endpoint.properties.cors.EndpointCorsProperties;
import de.seven.fate.entity.Order;
import de.seven.fate.enums.UserName;
import de.seven.fate.service.EndpointService;
import de.seven.fate.service.OrderValidationService;
import de.seven.fate.service.PublishEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
@ResponseBody
public class HomeResource {

    @Autowired
    private PublishEventService eventService;

    @Autowired
    private EndpointService endpointService;

    @Autowired
    private Environment environment;

    @Value("${endpoints.cors.foo:bar}")
    private String foo;

    @Autowired
    private OrderValidationService orderValidationService;

    @Autowired
    private OrderValidationService complexOrderValidationService;

    @RequestMapping("/")
    @ResponseBody
    public String home(@UserName String userName) {

        Order order = new Order();
        order.setDone(true);
        eventService.publishEvent(order);

        orderValidationService.validate(order);

        return "Hello Spring Boot!";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam String msg) {
        return "Hello " + msg;
    }

    @RequestMapping("/cors")
    @ResponseBody
    public EndpointCorsProperties corsProperties() {
        return endpointService.getEndpointCorsProperties();
    }

    @RequestMapping(value = "/property/{propertyName}", method = RequestMethod.GET)
    @ResponseBody
    public String getProperty(@UserName String userName, @PathVariable("propertyName") String propertyName) {
        return environment.getProperty(propertyName);
    }
}
