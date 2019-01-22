package org.mongo.timestamp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mongo.timestamp.config.properties.ApplicationProperties;
import org.mongo.timestamp.entity.Timestamp;
import org.mongo.timestamp.repository.TimestampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@Slf4j
public class BufferServiceImpl implements BufferService {
    @Autowired private TimestampRepository timestampRepository;
    @Autowired private ApplicationProperties applicationProperties;
    private Queue<Timestamp> tempBuffer = new ConcurrentLinkedQueue<>();

    @Override
    public void saveToBuffer(Timestamp timestamp) {
        tempBuffer.add(timestamp);
    }

    @Override
    public boolean bufferIsEmpty() {
        return tempBuffer.isEmpty();
    }

    @Override
    public void tryFlush() {
        try {
            timestampRepository.saveAll(tempBuffer);
            tempBuffer.clear();
        } catch (Exception e) {
            log.error(applicationProperties.getMessage().getConnectionUnreachable());
        }
    }
}
