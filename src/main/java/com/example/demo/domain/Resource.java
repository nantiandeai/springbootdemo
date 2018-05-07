package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Date;

@Configuration
@ConfigurationProperties(prefix = "com.example.demo")
@PropertySource(value = "classpath:resource.properties")
@Data
public class Resource {
    private String name;
    private String website;
    private String language;
    //    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GTM+8")
    private Date birthday = new Date();
}
