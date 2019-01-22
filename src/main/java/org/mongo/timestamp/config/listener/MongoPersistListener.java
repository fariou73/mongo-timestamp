package org.mongo.timestamp.config.listener;

import lombok.extern.slf4j.Slf4j;
import org.mongo.timestamp.config.constant.SpringProfile;
import org.mongo.timestamp.entity.Timestamp;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;

@Profile(SpringProfile.LOGGER)
@Component
@Slf4j
public class MongoPersistListener extends AbstractMongoEventListener<Timestamp> {
    @Override
    public void onAfterSave(AfterSaveEvent<Timestamp> event) {
        log.info("onAfterSave {}, {})", event.getSource(), event.getDocument());
    }
}
