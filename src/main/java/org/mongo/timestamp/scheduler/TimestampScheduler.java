package org.mongo.timestamp.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.mongo.timestamp.service.TimestampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;

@Slf4j
public class TimestampScheduler {
    @Autowired
    private TimestampService timestampService;

    @Scheduled(cron = "${custom.external.cron}")
    public void schedule() {
        log.info("schedule");
        timestampService.createAndSave();
    }
}
