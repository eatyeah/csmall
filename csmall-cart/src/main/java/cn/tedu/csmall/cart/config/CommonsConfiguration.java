package cn.tedu.csmall.cart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 配置spring扫描环境的配置类，必须添加配置注解@Configuration才能生效
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/9
 * @Time: 10:16
 */

@Configuration
@ComponentScan("cn.tedu.csmall.commons.exception")
public class CommonsConfiguration {
}
