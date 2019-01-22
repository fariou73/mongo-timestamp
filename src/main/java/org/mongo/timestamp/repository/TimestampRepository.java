package org.mongo.timestamp.repository;

import org.mongo.timestamp.entity.Timestamp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimestampRepository extends MongoRepository<Timestamp, String> {
}
