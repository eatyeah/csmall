package cn.tedu.csmall.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: sweeterjava@163.com
 * @Date: 2023/2/9
 * @Time: 15:08
 */

@Configuration
@MapperScan("cn.tedu.csmall.order.mapper")
public class MybatisConfiguration {
}
