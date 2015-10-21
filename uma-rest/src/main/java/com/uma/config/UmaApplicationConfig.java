package com.uma.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.uma.facades.config.UmaFacadesConfig;

@Configuration
@Import(UmaFacadesConfig.class)
@ImportResource({ "classpath:persistance-context.xml", "classpath:services-context.xml" })
public class UmaApplicationConfig {

}
