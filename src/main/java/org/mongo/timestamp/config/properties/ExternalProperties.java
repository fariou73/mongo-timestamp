package org.mongo.timestamp.config.properties;

import lombok.Data;

@Data
public class ExternalProperties {
    private int pageSize = 20;
    private String cron;
}
