package com.uma.controller.config;

import javax.inject.Inject;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.uma.controller.util.IntegrationTestUtil;
import com.uma.dao.permission.PermissionDao;
import com.uma.dao.user.UserDao;
import com.uma.dao.user.group.UserGroupDao;
import com.uma.facades.config.UmaFacadesConfig;

@Configuration
@Import({ UmaControllerConfig.class, UmaFacadesConfig.class })
@ImportResource({ "classpath:services-context.xml" })
public class IntegrationTestMockConfig extends WebMvcConfigurerAdapter {

	@Inject
	private WebApplicationContext appContext;

	@Inject
	private RequestMappingHandlerAdapter adapter;

	@Bean
	public UserDao userDao() {
		return Mockito.mock(UserDao.class);
	}

	@Bean
	public UserGroupDao userGroupDao() {
		return Mockito.mock(UserGroupDao.class);
	}

	@Bean
	public PermissionDao permissionDao() {
		return Mockito.mock(PermissionDao.class);
	}

	@Bean
	public IntegrationTestUtil getIntegrationTestUtil() {
		IntegrationTestUtil integrationTestUtil = new IntegrationTestUtil(adapter, appContext);
		return integrationTestUtil;
	}
}
