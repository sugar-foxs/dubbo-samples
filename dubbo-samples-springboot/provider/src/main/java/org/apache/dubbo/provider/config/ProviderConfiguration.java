package org.apache.dubbo.provider.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author guchunhui01
 * 2021/11/22
 **/
@Configuration
@EnableDubbo(scanBasePackages = "org.apache.dubbo.provider.service.impl")
@PropertySource("classpath:/application.properties")
public class ProviderConfiguration {
}
