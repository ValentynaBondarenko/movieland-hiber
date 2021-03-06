package org.nomarchia.movieland;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("org.nomarchia.movieland")
public class MovielandApplicationContext {
}
