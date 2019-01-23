package org.mongo.timestamp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mongo.timestamp.config.constant.SpringProfile;
import org.mongo.timestamp.service.BufferService;
import org.mongo.timestamp.service.TimestampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractTest {
}
