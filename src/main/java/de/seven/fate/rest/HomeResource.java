package de.seven.fate.rest;

import de.seven.fate.endpoint.properties.cors.EndpointCorsProperties;
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
    private EndpointCorsProperties endpointCorsProperties;

    @Autowired
    private Environment environment;

    @Value("${endpoints.cors.foo:bar}")
    private String foo;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello Spring boot!";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam String msg) {
        return "Hello " + msg;
    }

    @RequestMapping("/cors")
    @ResponseBody
    public EndpointCorsProperties corsProperties() {
        return endpointCorsProperties;
    }

    @RequestMapping(value = "/property/{propertyName}", method = RequestMethod.GET)
    @ResponseBody
    public String getProperty(@PathVariable("propertyName") String propertyName) {
        return environment.getProperty(propertyName);
    }
}
