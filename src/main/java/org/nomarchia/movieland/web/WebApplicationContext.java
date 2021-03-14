package org.nomarchia.movieland.web;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@Configuration
@ComponentScan("org.nomarchia.movieland.web.controller")
public class WebApplicationContext implements WebMvcConfigurer {
}
