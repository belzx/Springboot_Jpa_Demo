package com.lizhi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class RepositoryRestMvcConfig extends RepositoryRestMvcConfiguration {
    @Override
    public RepositoryRestConfiguration config() {
        return super.config();
    }
}
