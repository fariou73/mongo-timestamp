package org.mongo.timestamp.test;

import org.junit.Before;
import org.junit.Test;
import org.mongo.timestamp.entity.Timestamp;
import org.mongo.timestamp.repository.TimestampRepository;
import org.mongo.timestamp.service.BufferService;
import org.mongo.timestamp.service.TimestampService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;
import static org.mongo.timestamp.test.TestUtil.prepareTimestamps;

public class BufferServiceTest extends AbstractTest {
    @Autowired
    private BufferService bufferService;
    @Autowired
    private TimestampService timestampService;
    @Autowired
    private TimestampRepository timestampRepository;

    @Before
    public void before() {
        timestampRepository.deleteAll();
    }

    @Test
    public void test_save() {
        //GIVEN
        int count = 20;
        List<Timestamp> timestampsToBuffer = prepareTimestamps(count);
        //WHEN
        for (Timestamp timestamp : timestampsToBuffer) {
            bufferService.saveToBuffer(timestamp);
        }
        for (int i = 0; i< count; i++) {
            timestampService.createAndSave();
        }
        bufferService.tryFlush();
        //THEN
        assertEquals(timestampRepository.count(), count + count);
    }

    @Test
    public void test_save_ordering() throws InterruptedException {
        //GIVEN
        int count = 20;
        List<Timestamp> timestampsToBuffer = prepareTimestamps(count);
        //WHEN
        for (Timestamp timestamp : timestampsToBuffer) {
            bufferService.saveToBuffer(timestamp);
        }
        for (int i = 0; i< count; i++) {
            Thread.sleep(10);
            timestampService.createAndSave();
        }
        bufferService.tryFlush();
        //THEN
        List<Timestamp> all = timestampRepository.findAll();

        Timestamp last = all.get(0);

        for (int i = 1; i < all.size(); i++) {
            Timestamp current = all.get(i);

            assertTrue(!current.getTimestamp().isBefore(last.getTimestamp()));
            last = current;
        }
    }
}
