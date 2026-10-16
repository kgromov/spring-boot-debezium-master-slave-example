#!/usr/bin/env bash

curl -X POST -H "Content-Type: application/json" \
     --data @postgress-connector.json http://localhost:8083/connectors