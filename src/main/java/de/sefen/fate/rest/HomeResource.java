package de.sefen.fate.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@ResponseBody
public class HomeResource {

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
}
