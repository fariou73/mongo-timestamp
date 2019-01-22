package org.mongo.timestamp.config;

import org.mongo.timestamp.config.constant.SpringProfile;
import org.mongo.timestamp.scheduler.BufferScheduler;
import org.mongo.timestamp.scheduler.TimestampScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Profile(SpringProfile.WRITER)
@Configuration
@EnableScheduling
public class WriterConfig {
    @Bean
    public TimestampScheduler timestampScheduler() {
        return new TimestampScheduler();
    }

    @Bean
    public BufferScheduler bufferScheduler() {
        return new BufferScheduler();
    }
}
