package com.yuw.configs;

import com.yuw.converter.DateTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

@Configuration
public class DateConverterConfiguration {

    // 使用spring依赖注入requestMappingHandlerAdapter对象，进行自定义数据类型转换处理

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    /**
     * 注册加载自定义转换器
     * 构造方法构建完成之后执行
     */
    @PostConstruct
    public void addCoverters() {
        // 获取绑定器对象
        ConfigurableWebBindingInitializer configurableWebBindingInitializer =
                (ConfigurableWebBindingInitializer) requestMappingHandlerAdapter.getWebBindingInitializer();
        // 加入自定义转换器
        if (configurableWebBindingInitializer.getConversionService() != null) {
            GenericConversionService genericConversionService = (GenericConversionService) configurableWebBindingInitializer.getConversionService();
            // 此处可以添加自定义类型转换器
            genericConversionService.addConverter(new DateTypeConverter());
            // 此处可以继续加入其它的自定义类型转换器类
        }
    }
}
