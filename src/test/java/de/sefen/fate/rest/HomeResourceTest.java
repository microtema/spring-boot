package de.sefen.fate.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
@SpringBootTest(classes = HomeResource.class)
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
        perform.andExpect(content().string(equalTo("Hello Spring boot!")));
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