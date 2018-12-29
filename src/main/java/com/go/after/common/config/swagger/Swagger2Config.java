package com.go.after.common.config.swagger;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author dong
 */
@Slf4j
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 标题
     */
    @Value("${swagger.title}")
    private String title;

    /**
     * 描述
     */
    @Value("${swagger.description}")
    private String description;

    /**
     * 版本
     */
    @Value("${swagger.version}")
    private String version;
    /**
     *
     */
    @Value("${swagger.termsOfServiceUrl}")
    private String termsOfServiceUrl;

    /**
     * 作者
     */
    @Value("${swagger.contact.name}")
    private String name;

    /**
     * 作者博客或者是网址
     */
    @Value("${swagger.contact.url}")
    private String url;

    /**
     * 作者邮箱!
     */
    @Value("${swagger.contact.email}")
    private String email;

    @Bean
    public Docket createRestApi() {

        log.info("加载Swagger2");

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select()
                //扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(new Contact(name, url, email))
                .version(version)
                .build();
    }
}
