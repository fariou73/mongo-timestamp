package org.mongo.timestamp.controller;

import lombok.extern.slf4j.Slf4j;
import org.mongo.timestamp.config.properties.ApplicationProperties;
import org.mongo.timestamp.entity.Timestamp;
import org.mongo.timestamp.service.TimestampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.annotation.PostConstruct;

@Slf4j
public class TimestampController {
    @Autowired
    private TimestampService timestampService;
    @Autowired
    private ApplicationProperties applicationProperties;

    @PostConstruct
    public void init() {
        int currentPage = 0;
        int pageSize = applicationProperties.getExternal().getPageSize();
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<Timestamp> timestampPage = timestampService.getTimestamps(pageable);
        while (timestampPage.hasNext()) {
            currentPage += 1;
            pageable = PageRequest.of(currentPage, pageSize);
            timestampPage = timestampService.getTimestamps(pageable);
        }
    }
}
