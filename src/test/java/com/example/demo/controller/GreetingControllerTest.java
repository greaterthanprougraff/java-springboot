package com.example.demo.controller;

import com.example.demo.model.NameEntry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPostGreetingWithName() throws Exception {
        String json = "{\"name\":\"Charlie\"}";
        mockMvc.perform(post("/greeting")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Charlie"));
    }

    @Test
    void testPostGreetingWithoutName() throws Exception {
        String json = "{}";
        mockMvc.perform(post("/greeting")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Name is required."));
    }

    @Test
    void testGetGreetingNotFound() throws Exception {
        mockMvc.perform(get("/greeting/999"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("No name allotted for this ID."));
    }

    @Test
    void testPutGreeting() throws Exception {
        String json = "{\"id\":0, \"name\":\"Alice\"}";
        mockMvc.perform(put("/greeting")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":0,\"name\":\"Alice\"}"));
    }

    @Test
    void testPutGreetingWithEmptyName() throws Exception {
        String json = "{\"id\":0, \"name\":\"\"}";
        mockMvc.perform(put("/greeting")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("New name is required."));
    }

    @Test
    void testPutGreetingWithNonExistentId() throws Exception {
        String json = "{\"id\":999, \"name\":\"Bob\"}";
        mockMvc.perform(put("/greeting")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isNotFound())
                .andExpect(content().string("No name allotted for this ID."));
    }

    @Test
    void testDeleteGreeting() throws Exception {
        mockMvc.perform(delete("/greeting/0"))
                .andExpect(status().isOk())
                .andExpect(content().string("Name for ID 0 deleted."));
    }

    @Test
    void testDeleteGreetingNotFound() throws Exception {
        mockMvc.perform(delete("/greeting/999"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("No name allotted for this ID."));
    }
}
