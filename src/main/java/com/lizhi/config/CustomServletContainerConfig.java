package com.lizhi.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 惯用配置
 * 1：配置错误页面
 * 2：ession过期时间 等的
 *
 */
@Component
public class CustomServletContainerConfig implements EmbeddedServletContainerCustomizer {


    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        //设置端口
//        configurableEmbeddedServletContainer.setPort(8080);

        //设置404页面
        //页面默认的地址为 src/main/resources/static
        configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));

        //10分钟session过期
        configurableEmbeddedServletContainer.setSessionTimeout(10,TimeUnit.MINUTES);
    }
}
