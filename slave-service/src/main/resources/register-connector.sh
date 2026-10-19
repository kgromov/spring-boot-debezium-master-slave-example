#!/usr/bin/env bash

curl -X POST http://localhost:8083/connectors -H "Content-Type: application/json" -d @postgres-connepostgress-connector_generic.json

curl http://localhost:8083/connectors -H "Content-Type: application/json" -d '
{
  "name": "mysql_sink_connector",
  "config": {
    "connector.class": "io.debezium.connector.jdbc.JdbcSinkConnector",
    "connection.url": "jdbc:mysql://mysql:3306/debezium_slave",
    "connection.username": "root",
    "connection.password": "root",
    "topics": "postgres.public.customer",
    "insert.mode": "upsert",
    "primary.key.mode": "record_key",
    "delete.enabled": "true",
    "schema.evolution": "basic",
    "table.name.format": "customer"
  }
}'