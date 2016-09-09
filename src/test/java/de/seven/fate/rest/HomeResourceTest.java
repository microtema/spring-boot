package de.seven.fate.rest;

import de.seven.fate.aspect.UserNameAspect;
import de.seven.fate.endpoint.properties.cors.EndpointCorsProperties;
import de.seven.fate.entity.Order;
import de.seven.fate.event.CreationEvent;
import de.seven.fate.enums.UserName;
import de.seven.fate.rule.ComplexOrderRule;
import de.seven.fate.rule.OrderRule;
import de.seven.fate.rule.SimpleOrderRule;
import de.seven.fate.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HomeResource.class, EndpointCorsProperties.class, CorsEndpointService.class, EndpointService.class,
        PublishEventService.class, Order.class, OrderRule.class, SimpleOrderRule.class, ComplexOrderRule.class, CreationEvent.class, OrderValidationService.class, OrderValidationServiceImpl.class, UserName.class, UserNameAspect.class})
@ImportResource("classpath:beans.xml")
@AutoConfigureMockMvc
public class HomeResourceTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void home() throws Exception {
        //when
        ResultActions perform = mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON));

        //then
        perform.andExpect(status().isOk());
        perform.andExpect(content().string(equalTo("Hello Spring Boot!")));
    }

    @Test
    public void hello() throws Exception {
        //given
        String msg = UUID.randomUUID().toString();

        //when
        ResultActions perform = mvc.perform(MockMvcRequestBuilders.get("/hello?msg=" + msg).accept(MediaType.APPLICATION_JSON));

        //then
        perform.andExpect(status().isOk());
        perform.andExpect(content().string(equalTo("Hello " + msg)));
    }

}