package com.youtube.javapuzzle.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "slave.datasource")
public class SlaveConnectorProperties {
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;
}
