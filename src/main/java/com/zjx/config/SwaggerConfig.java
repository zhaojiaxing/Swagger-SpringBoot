package com.zjx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket applicationApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户")
                .select()  // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.zjx.controller"))
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build()
                .apiInfo(applicationInfo());
    }


    private ApiInfo applicationInfo() {
        ApiInfo apiInfo = new ApiInfo("用户相关接口",//大标题
                "关于用户添加的接口" ,//小标题
                "0.1",//版本
                "成都",
                new Contact("zjx", "", ""),// 作者
                "",//链接显示文字
                ""//网站链接
        );
        return apiInfo;
    }


    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
