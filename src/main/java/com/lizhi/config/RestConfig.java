package com.lizhi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RepositoryRestMvcConfig.class)
public class RestConfig {
}
