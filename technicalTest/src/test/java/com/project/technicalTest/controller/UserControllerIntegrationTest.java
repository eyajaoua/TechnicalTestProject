package com.project.technicalTest.controller;





import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Calendar;
import java.util.GregorianCalendar;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.technicalTest.controllers.UserController;
import com.project.technicalTest.models.User;
import com.project.technicalTest.repository.UserRepository;
import com.project.technicalTest.services.UserService;

@RunWith(SpringRunner.class) 
@WebMvcTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserService userService;
    
    @Autowired
    UserController userController;
    
    
    

    @Autowired
    private MockMvc mockMvc;
    
    private ObjectMapper objectMapper = new ObjectMapper();
    
    
    @Test
    public void test_createUser() throws Exception {
 

    	
    		User user1 = new User("userTest12",
    				new GregorianCalendar(2020, Calendar.JANUARY,11).getTime(),
    				"france");
    		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
    				.contentType("application/json")
    				.content(objectMapper.writeValueAsString(user1))).andReturn();
    		assertEquals( 201, result.getResponse().getStatus());
    	
    }


   	
    	@Test
    	public void test_findUserById() throws Exception {
    		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
    				.get("/users/{id}", 6)
    				.contentType("application/json"))
    				.andReturn();
    		assertEquals(  404, result.getResponse().getStatus());
    	}
}    		
    	
    		
    	
    	
    
    


    

