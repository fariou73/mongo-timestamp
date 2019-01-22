package org.mongo.timestamp.config;

import org.mongo.timestamp.config.constant.SpringProfile;
import org.mongo.timestamp.controller.TimestampController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(SpringProfile.READER)
@Configuration
public class ReaderConfig {
    @Bean
    public TimestampController timestampController() {
        return new TimestampController();
    }
}
