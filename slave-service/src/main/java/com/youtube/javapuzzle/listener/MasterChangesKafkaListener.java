package com.youtube.javapuzzle.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.javapuzzle.model.CustomerChanges;
import com.youtube.javapuzzle.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MasterChangesKafkaListener {
    private final CustomerService customerService;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @KafkaListener(topics = "postgres.public.customer")
    public void onMasterChanges(Message<String> message) {
        CustomerChanges changes = objectMapper.readerFor(CustomerChanges.class).readValue(message.getPayload());
        customerService.replicateData(changes);
    }
}
