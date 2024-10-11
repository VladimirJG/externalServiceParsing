package ru.danilov.externalServiceParsing.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import ru.danilov.externalServiceParsing.dto.LinkTagDto;

public class LinkTagDtoSerializer implements Serializer<LinkTagDto> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, LinkTagDto linkTagDto) {
        try {
            return objectMapper.writeValueAsBytes(linkTagDto);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing LinkTagDto", e);
        }
    }
}
