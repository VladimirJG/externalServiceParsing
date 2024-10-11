package ru.danilov.externalServiceParsing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.danilov.externalServiceParsing.dto.LinkTagDto;

@Service
public class KafkaProducerService {
    //TODO maybe final
    private KafkaTemplate<String, LinkTagDto> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, LinkTagDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, LinkTagDto linkTagDto) {
        kafkaTemplate.send(topic, linkTagDto);
    }
}
