package com.crud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author silvae
 */
@Configuration
@PropertySource("classpath:pro.properties")
@Profile("pro")
public class PropertiesSourcePro {
    
}
