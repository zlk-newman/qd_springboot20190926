package com.yuw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* 约定大于配置：
* 约定1：springboot对于注解的扫描范围默认是从当前的main方法的Springboot20190926Application类所在位置开始；
*        所以，使用注解的类，需要放在main方法类的下面；
* 约定2：使用了@SpringBootApplication注解的类就是springboot的启动类，使用main方法启动springboot即可；
*        @SpringBootApplication 是一个组合注解，等价于：
*           @Configuration（表示进行springboot的配置实体类，等价加载了一个xml配置文件） ，
*           @EnableAutoConfiguration（表示使用加载springboot的默认配置）
*           @ComponentScan (使用该注解的类，都会作为spring的一个组件bean被扫描加载)
* 约定3：使用注解 @MapperScan 指明mybatis的dao层位置，
*        类似于spring集成mybatis的 org.mybatis.spring.mapper.MapperScannerConfigurer bean的配置
* */

@MapperScan("com.yuw.dao") // 1、在主启动文件配置；2、在mapper的接口类中使用注解 @Mapper
@SpringBootApplication
public class Springboot20190926Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot20190926Application.class, args);
    }
}
