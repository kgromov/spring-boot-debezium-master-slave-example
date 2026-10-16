#!/usr/bin/env bash

curl -X POST -H "Content-Type: application/json" \
     --data @postgres-connector.json http://localhost:8083/connectors

curl http://localhost:8083/connectors -H "Content-Type: application/json" -d '
{
  "name": "customer_postgres_connector",
  "config": {
    "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
    "plugin.name": "pgoutput",
    "database.hostname": "postgres",
    "database.port": "5432",
    "database.user": "docker",
    "database.password": "docker",
    "database.dbname": "debezium_master",
    "database.server.name": "postgres",
    "topic.prefix": "postgres",
    "table.include.list": "public.customer",
    "key.converter": "org.apache.kafka.connect.json.JsonConverter",
    "value.converter": "org.apache.kafka.connect.json.JsonConverter",
    "key.converter.schemas.enable": "false",
    "value.converter.schemas.enable": "false",
    "transforms": "unwrap",
    "transforms.unwrap.type": "io.debezium.transforms.ExtractNewRecordState",
    "transforms.unwrap.delete.handling.mode": "rewrite",
    "transforms.unwrap.drop.tombstones": "true",
    "transforms.unwrap.add.fields": "op,table",
    "transforms.unwrap.add.headers": "op"
  }
}'