package com.youtube.javapuzzle.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * {
 * 		"version": "1.4.2.Final",
 * 		"connector": "postgresql",
 * 		"name": "postgres",
 * 		"ts_ms": 1792278487476,
 * 		"snapshot": "false",
 * 		"db": "debezium_master",
 * 		"schema": "public",
 * 		"table": "customer",
 * 		"txId": 513,
 * 		"lsn": 23929760,
 * 		"xmin": null
 * 	    }
 */
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConnectorMetadata {
    private String connector;
    @JsonProperty("name")
    private String connectorName;
    private String schema;
    @JsonProperty("db")
    private String database;
    private String table;
    private String version;
}
