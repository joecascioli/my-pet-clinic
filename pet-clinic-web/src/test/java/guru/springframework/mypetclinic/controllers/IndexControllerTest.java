package guru.springframework.mypetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {

    IndexController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        controller = new IndexController();

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void index() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void oups() throws Exception {
        mockMvc.perform(get("/oups"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));
    }
}