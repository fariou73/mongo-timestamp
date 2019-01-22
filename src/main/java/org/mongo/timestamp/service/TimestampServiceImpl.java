package org.mongo.timestamp.service;

import org.mongo.timestamp.entity.Timestamp;
import org.mongo.timestamp.repository.TimestampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TimestampServiceImpl implements TimestampService {
    @Autowired
    private TimestampRepository repository;

    @Override
    public Page<Timestamp> getTimestamps(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void createAndSave() {
        repository.save(new Timestamp());
    }
}
