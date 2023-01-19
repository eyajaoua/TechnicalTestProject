package com.project.technicalTest.services;

import com.project.technicalTest.models.User;
import com.project.technicalTest.repository.UserRepository;
import com.project.technicalTest.services.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.mockito.ArgumentMatchers;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

//public class UserServiceTest {
//	private UserRepository userRepository = Mockito.mock(UserRepository.class);
//	
//	@Test
//	public void whenSaveUser_shouldReturnUser() {
//	User user =  new User("usertest23",  new GregorianCalendar(2020, Calendar.JANUARY,11).getTime(), "france");
//	
//	when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);
//	//User created = userService.createNewUser(user);
//	//assertThat(created.getUserName()).isSameAs(user.getUserName());
//	verify(userRepository).save(user);
//	
//
//	
//	
//	}
//}

@RunWith(SpringRunner.class) 
public class UserServiceTest {

    @MockBean
	private UserRepository userRepository;
//	

	@InjectMocks
	private UserService userService = new UserService(userRepository);

	@Test
	public void test_createUser() {
		User user1 = new User("usertest20", new GregorianCalendar(2000, Calendar.NOVEMBER, 4).getTime(), "france");
		when(userRepository.save(user1)).thenReturn(user1);
		assertEquals(user1, userService.createUser(user1));
	}

	@Test
	public void test_findUsers() {
		List<User> user = userService.getUsers();
		Mockito.verify(userRepository).findAll();
	}

}
