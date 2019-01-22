package org.mongo.timestamp.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "custom", ignoreInvalidFields = false, ignoreUnknownFields = false)
public class ApplicationProperties {
    private MessageProperties message;
    private ExternalProperties external;
}
