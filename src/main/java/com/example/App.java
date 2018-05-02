package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class App {

    @Bean
    WebMvcConfigurer configurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/bootstrap/**")
                        .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/")
                        .setCacheControl(CacheControl.maxAge(30L, TimeUnit.DAYS).cachePublic());

                registry.addResourceHandler("/jquery/**")
                        .addResourceLocations("classpath:/META-INF/resources/webjars/jquery/")
                        .setCacheControl(CacheControl.maxAge(30L, TimeUnit.DAYS).cachePublic());
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
