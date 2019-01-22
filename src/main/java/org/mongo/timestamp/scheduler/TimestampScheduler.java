package org.mongo.timestamp.scheduler;

import org.mongo.timestamp.service.TimestampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;

public class TimestampScheduler {
    @Autowired
    private TimestampService timestampService;

    @Scheduled(cron = "${custom.external.cron}")
    public void schedule() {
        timestampService.createAndSave();
    }
}
