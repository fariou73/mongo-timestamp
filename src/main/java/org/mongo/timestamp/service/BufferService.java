package org.mongo.timestamp.service;

import org.mongo.timestamp.entity.Timestamp;

import java.util.List;

public interface BufferService {
    void saveToBuffer(Timestamp timestamp);

    boolean bufferIsEmpty();

    void tryFlush();
}
