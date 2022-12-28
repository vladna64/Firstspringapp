package com.example.validatingforminput.personTest;

import com.example.person.PersonController;
import com.example.person.PersonForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(PersonController.class)

@SpringBootTest
@AutoConfigureMockMvc
public class PersonInput {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void getPersonInfo () throws Exception {
////        PersonForm personForm = new PersonForm(2,"jjjjj","jjjjj",18,true,2.2, "A".charAt(0));
//
////        long id = createTestPerson("Michail").getId();
//
////        mockMvc.perform(get("/")
////        )
////                        .andExpect(status().is2xxSuccessful())
////                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
////                        .andExpect(jsonPath(".id").value(1))
////                        .andExpect(jsonPath(".firstname").value("aoisxaosxm"))
////                        .andExpect(jsonPath(".lastname").value("sasxäaösx"))
////                        .andExpect(jsonPath(".age").value(20))
////                        .andExpect(jsonPath(".start").value(true))
////                        .andExpect(jsonPath(".procent").value(2.2))
////                        .andExpect(jsonPath(".des_score").value("A"));
////
////    }

    @Test
    public void addPersonInfo () throws Exception {
        PersonForm personForm = new PersonForm(1,"jjjjj","jjjjj",18,true,2.2, "A".charAt(0));

        mockMvc.perform(post("/")
                .content(objectMapper.writeValueAsString(personForm))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(".id").value(2))
                .andExpect(jsonPath(".firstname").value("jjjjj"))
                .andExpect(jsonPath(".lastname").value("jjjjj"))
                .andExpect(jsonPath(".age").value(18))
                .andExpect(jsonPath(".start").value(true))
                .andExpect(jsonPath(".procent").value(2.2))
                .andExpect(jsonPath(".des_score").value("A"));
    }

    @Test
    public  void updatePersonInfo() throws Exception {
        PersonForm personForm = new PersonForm(1,"jjjlkdlcsdjj","jjjjj",18,true,2.2, "A".charAt(0));
        mockMvc.perform(get("/update?id=1")
                .content(objectMapper.writeValueAsString(personForm))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(".id").value(2))
                .andExpect(jsonPath(".firstname").value("jjjlkdlcsdjj"))
                .andExpect(jsonPath(".lastname").value("jjjjj"))
                .andExpect(jsonPath(".age").value(18))
                .andExpect(jsonPath(".start").value(true))
                .andExpect(jsonPath(".procent").value(2.2))
                .andExpect(jsonPath(".des_score").value("A"));
    }

    @Test
    public void showOnePersonInfo() throws Exception {
        mockMvc.perform(put("/one?id=1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(".id").value(2))
                .andExpect(jsonPath(".firstname").value("jjjlkdlcsdjj"))
                .andExpect(jsonPath(".lastname").value("jjjjj"))
                .andExpect(jsonPath(".age").value(18))
                .andExpect(jsonPath(".start").value(true))
                .andExpect(jsonPath(".procent").value(2.2))
                .andExpect(jsonPath(".des_score").value("A"));
    }

    @Test
    public void deletePersonInfo() throws Exception {
        mockMvc.perform(delete("/delete?id=1"))
                .andExpect(status().is2xxSuccessful());
    }
}
