package org.mongo.timestamp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
public class Timestamp {
    @Id
    private String id;
    private Instant timestamp = Instant.now();
}
