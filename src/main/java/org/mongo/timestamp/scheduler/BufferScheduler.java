package org.mongo.timestamp.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.mongo.timestamp.service.BufferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
public class BufferScheduler {
    @Autowired
    private BufferService bufferService;

    @Scheduled(cron = "${custom.external.flushCron}")
    public void flush() {
        log.info("flush");
        bufferService.tryFlush();
    }
}
