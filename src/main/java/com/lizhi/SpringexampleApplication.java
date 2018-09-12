package com.lizhi;

import com.lizhi.custom.config.CustomRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)//
//@ImportResource({"classpath:test.xml"})//提供额外的配置扫描
public class SpringexampleApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringexampleApplication.class, args);
//        new SpringApplication(SpringexampleApplication.class).可以关闭banbner
    }



}
