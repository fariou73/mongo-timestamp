package org.mongo.timestamp.service;

import org.mongo.timestamp.entity.Timestamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TimestampService {
    Page<Timestamp> getTimestamps(Pageable pageable);

    void createAndSave();
}
