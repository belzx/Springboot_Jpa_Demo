package com.lizhi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //开启对事务的扫描，不许要显示开启，因为默认开启了
public class TransactionConfig {

    //或者也可以通过手动启用四五
}
