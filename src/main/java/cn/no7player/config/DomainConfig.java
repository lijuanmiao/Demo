package cn.no7player.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by lijm on 2018-03-29.
 */
@Configuration
@ConfigurationProperties
public class DomainConfig {

    List<String> domain;
}
