package ru.danilov.externalServiceParsing.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.danilov.externalServiceParsing.dto.LinkTagDto;

import java.util.List;

@Service
public class ScheduledKafkaProducer {
    private final ExternalServiceParsingService parsingService;
    private final KafkaProducerService kafkaProducerService;

    public ScheduledKafkaProducer(ExternalServiceParsingService parsingService, KafkaProducerService kafkaProducerService) {
        this.parsingService = parsingService;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Scheduled(fixedRate = 120000) // Отправка сообщения каждые 2 минуты
    public void sendScheduledMessage() {
        List<LinkTagDto> extracted = extracted();
        extracted.forEach(linkTagDto -> kafkaProducerService.sendMessage("out-quality", linkTagDto));
    }

    private List<LinkTagDto> extracted() {
        return parsingService.fetchAndParseLinkTags().block();
    }
}
