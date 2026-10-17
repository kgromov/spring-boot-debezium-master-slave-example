#!/usr/bin/env bash

curl -X POST -H "Content-Type: application/json" \
     --data @postgres-connector.json http://localhost:8083/connectors

curl http://localhost:8083/connectors -H "Content-Type: application/json" -d '
{$json}'