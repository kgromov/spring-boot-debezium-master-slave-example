package com.youtube.javapuzzle.listener;

import com.youtube.javapuzzle.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MasterChangesKafkaListener {
    private final CustomerService customerService;

    @KafkaListener(topics = "postgres.public.customer")
    public <T> void onMasterChanges(Message<T> message) {
        var sourceRecord = message.getPayload();
        log.info("{}", com.fasterxml.jackson.databind.ObjectMapper.class.getProtectionDomain().getCodeSource().getLocation());
      /*  log.info("Key = {}, Value = {}", sourceRecord.key(), sourceRecord.value());
        var sourceRecordChangeValue = (Struct) sourceRecord.value();
        log.info("SourceRecordChangeValue = '{}'", sourceRecordChangeValue);
        if (sourceRecordChangeValue != null) {
            Envelope.Operation operation = Envelope.Operation.forCode((String) sourceRecordChangeValue.get(OPERATION));

//         Operation.READ operation events are always triggered when application initializes
//         We're only interested in CREATE operation which are triggered upon new insert registry
            if (operation != Envelope.Operation.READ) {
                String record = operation == Envelope.Operation.DELETE ? BEFORE : AFTER; // Handling Update & Insert operations.
                Struct struct = (Struct) sourceRecordChangeValue.get(record);
                Map<String, Object> payload = struct.schema().fields().stream()
                        .map(Field::name)
                        .filter(fieldName -> struct.get(fieldName) != null)
                        .map(fieldName -> Pair.of(fieldName, struct.get(fieldName)))
                        .collect(toMap(Pair::getKey, Pair::getValue));

                customerService.replicateData(payload, operation);
                log.info("Updated Data: {} with Operation: {}", payload, operation.name());
            }
        }*/
    }
}
