package com.example.spring.logging.responserequest.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerIT
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    // ============================== [Unit Tests] ==============================

    // -------------------- [Test Helper Classes] --------------------

    // -------------------- [Test Helper Methods] --------------------

    // -------------------- [Test Initialization] --------------------

    // -------------------- [Tests] --------------------

    @Test
    void getTest() throws Exception
    {
        //        mvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk());
        mvc.perform(get("/hello")).andExpect(status().isOk());
    }

    @Test
    void postTest() throws Exception
    {
        Hello hello = new Hello("This is a test.");
        String jsonStr = this.objectMapper.writeValueAsString(hello);

        //        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isOk());
        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andExpect(status().isOk());
    }
}
