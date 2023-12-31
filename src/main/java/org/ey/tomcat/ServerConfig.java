package org.ey.tomcat;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = { "org.ey.tomcat" })
@PropertySource("classpath:server.properties")
public class ServerConfig {
}
