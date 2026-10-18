package com.youtube.javapuzzle.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@EnableConfigurationProperties(SlaveConnectorProperties.class)
@Configuration
public class DebeziumConnectorConfig {

    /*
     * This is equivalent to debezium.json with more details/customizations and offset.storage.
     * debesium publishes connector.json (and actually worker config.json) itself with kafka REST.
     */
    @Bean
    public io.debezium.config.Configuration customerConnector(SlaveConnectorProperties connectorProperties) throws IOException {
        var offsetStorageTempFile = File.createTempFile("offsets_", ".dat");
        return io.debezium.config.Configuration.create()
            .with("name", "customer_postgres_connector")
            .with("connector.class", "io.debezium.connector.postgresql.PostgresConnector")
            .with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore")
            .with("offset.storage.file.filename", offsetStorageTempFile.getAbsolutePath())
            .with("offset.flush.interval.ms", "60000")
            .with("database.hostname", connectorProperties.getHost())
            .with("database.port", connectorProperties.getPort())
            .with("database.user", connectorProperties.getUsername())
            .with("database.password", connectorProperties.getPassword())
            .with("database.dbname", connectorProperties.getDatabase())
            .with("database.server.id", "10181")
            .with("database.server.name", "customer-postgres-db-server")
            .with("topic.prefix", "slave-postgresql")
            .with("database.history", "io.debezium.relational.history.MemoryDatabaseHistory")
//            .with("table.include.list", "public.claims")
//            .with("column.include.list", "public.customer.email,public.customer.fullname")
            .with("publication.autocreate.mode", "all_tables")
            .with("plugin.name", "pgoutput")
            .with("slot.name", "dbz_customerdb_listener")
            .build();
    }
}
