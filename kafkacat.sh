#!/bin/bash

docker run --tty --network spring-boot-debezium-master-slave-example_default confluentinc/cp-kafkacat \
kafkacat -b kafka:9092 -C -s key=s -s value=avro -r http://schema-registry:8081 -t postgres.public.customer

# alternative way not to configure kafka-ui
# docker run --rm -p 8000:8000 -e "SCHEMAREGISTRY_URL=http://schema.registry:8081" landoop/schema-registry-ui
