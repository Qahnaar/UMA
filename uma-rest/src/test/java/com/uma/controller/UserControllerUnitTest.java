package com.uma.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.uma.facades.dtos.user.DefaultUserDto;
import com.uma.facades.user.UserFacade;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerUnitTest {

	private static final Long TEST_ID = Long.valueOf(1L);
	private static final String TEST_EMAIL = "test@test.com";
	private static final String TEST_PASSWORD = "a1s2D3F$";
	private static final String TEST_NICKNAME = "Nick";

	@InjectMocks
	private UserController unit;

	@Mock
	private UserFacade userFacade;

	ArgumentCaptor<DefaultUserDto> userDtoCaptor = ArgumentCaptor.forClass(DefaultUserDto.class);

	private DefaultUserDto userDto;

	private Set<DefaultUserDto> userDtosCollection;

	@Before
	public void setUp() {
		setUpUserDto();
		userDtosCollection = Collections.singleton(userDto);
	}

	@Test
	public void shouldReturnAllUserDtos() {
		when(userFacade.findAll()).thenReturn(userDtosCollection);

		assertEquals(userDtosCollection, unit.getUsers());

		verify(userFacade, times(BigDecimal.ONE.intValue())).findAll();
	}

	@Test
	public void shouldFindUserById() {
		when(userFacade.find(TEST_ID)).thenReturn(userDto);

		assertEquals(userDto, unit.getUser(TEST_ID));

		verify(userFacade, times(BigDecimal.ONE.intValue())).find(TEST_ID);
	}

	@Test
	public void shouldSaveUser() {
		unit.saveUser(userDto);

		verify(userFacade, times(BigDecimal.ONE.intValue())).save(userDtoCaptor.capture());
		assertEquals(userDto, userDtoCaptor.getValue());
	}

	@Test
	public void shouldUpdateUser() {
		unit.updateUser(userDto);

		verify(userFacade, times(BigDecimal.ONE.intValue())).merge(userDtoCaptor.capture());
		assertEquals(userDto, userDtoCaptor.getValue());
	}

	@Test
	public void shouldDeleteUser() {
		unit.deleteUser(userDto);

		verify(userFacade, times(BigDecimal.ONE.intValue())).remove(userDtoCaptor.capture());
		assertEquals(userDto, userDtoCaptor.getValue());
	}

	private void setUpUserDto() {
		userDto = new DefaultUserDto();
		userDto.setId(TEST_ID);
		userDto.setEmail(TEST_EMAIL);
		userDto.setNickname(TEST_NICKNAME);
		userDto.setPassword(TEST_PASSWORD);
	}
}
