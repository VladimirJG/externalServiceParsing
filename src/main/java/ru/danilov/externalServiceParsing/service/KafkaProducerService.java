package ru.danilov.externalServiceParsing.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.danilov.externalServiceParsing.dto.LinkTagDto;

import java.util.List;

@Service
public class KafkaProducerService {
    private KafkaTemplate<String, List<LinkTagDto>> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, List<LinkTagDto>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, List<LinkTagDto> linkTagDtoList) {
        kafkaTemplate.send(topic, linkTagDtoList);
    }
}
