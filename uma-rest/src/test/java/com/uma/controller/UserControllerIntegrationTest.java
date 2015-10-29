package com.uma.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;

import com.uma.controller.config.IntegrationTestMockConfig;
import com.uma.controller.util.IntegrationTestUtil;
import com.uma.dao.user.UserDao;
import com.uma.domain.user.User;
import com.uma.facades.dtos.user.DefaultUserDto;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { IntegrationTestMockConfig.class })
public class UserControllerIntegrationTest {

	private static final Long TEST_ID = Long.valueOf(1L);
	private static final String TEST_EMAIL = "test@test.com";
	private static final String TEST_PASSWORD = "a1s2D3F$";
	private static final String TEST_NICKNAME = "Nick";

	@Autowired
	private UserDao userDao;

	private User user;

	private DefaultUserDto userDto;

	private Set<User> usersCollection;

	private Set<DefaultUserDto> userDtosCollection;

	@Autowired
	private IntegrationTestUtil testUtil;

	@Before
	public void setUp() {
		setUpUser();
		setUpUserDto();
		usersCollection = Collections.singleton(user);
		userDtosCollection = Collections.singleton(userDto);
	}

	@Test
	public void shouldReturnUsers() throws Exception {

		String expectedResponse = testUtil.getObjectAsString(userDtosCollection);

		when(userDao.readAll()).thenReturn(usersCollection);

		MvcResult actualReturn = testUtil.getMockMvc().perform(get("/users")).andExpect(status().isOk()).andReturn();
		String actualResponse = actualReturn.getResponse().getContentAsString();

		assertEquals(expectedResponse, actualResponse);

		verify(userDao, times(1)).readAll();
		verifyNoMoreInteractions(userDao);
	}

	private void setUpUser() {
		user = new User();
		user.setId(TEST_ID);
		user.setEmail(TEST_EMAIL);
		user.setNickname(TEST_NICKNAME);
		user.setPassword(TEST_PASSWORD);
	}

	private void setUpUserDto() {
		userDto = new DefaultUserDto();
		userDto.setId(TEST_ID);
		userDto.setEmail(TEST_EMAIL);
		userDto.setNickname(TEST_NICKNAME);
		userDto.setPassword(TEST_PASSWORD);
	}
}
