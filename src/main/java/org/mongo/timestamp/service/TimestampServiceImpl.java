package org.mongo.timestamp.service;

import com.mongodb.MongoException;
import lombok.AllArgsConstructor;
import org.mongo.timestamp.entity.Timestamp;
import org.mongo.timestamp.repository.TimestampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TimestampServiceImpl implements TimestampService {
    private final TimestampRepository repository;
    private final BufferService bufferService;

    @Override
    public Page<Timestamp> getTimestamps(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Async
    public void createAndSave() {
        Timestamp timestamp = new Timestamp();

        if (bufferService.bufferIsEmpty()) {
            try {
                repository.save(timestamp);
            } catch (Exception exception) {
                bufferService.saveToBuffer(timestamp);
            }
        } else {
            bufferService.saveToBuffer(timestamp);
        }
    }
}
