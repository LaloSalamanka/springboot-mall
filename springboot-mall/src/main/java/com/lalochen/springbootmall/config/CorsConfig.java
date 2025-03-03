package com.lalochen.springbootmall.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Value("${frontend.url}")
    private String allowedOrigins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // 配置所有路徑
                        .allowedOrigins(allowedOrigins) // 允許的域名
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允許的方法
                        .allowedHeaders("*") // 允許的標頭
                        .allowCredentials(true); // 是否允許帶憑證的請求
            }
        };
    }
}
