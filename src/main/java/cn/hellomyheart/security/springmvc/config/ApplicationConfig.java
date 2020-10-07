package cn.hellomyheart.security.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @description 配置类
 * @className: ApplicationConfig
 * @package: cn.hellomyheart.security.springmvc.config
 * @author: Stephen Shen
 * @date: 2020/10/7 下午2:59
 */
@Configuration //相当于applicationContext.xml
@ComponentScan(basePackages = "cn.hellomyheart.security.springmvc"
        , excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationConfig {
    //配置除了controller的其他bean,比如数据库连接池、事务管理器、业务bean。

}
