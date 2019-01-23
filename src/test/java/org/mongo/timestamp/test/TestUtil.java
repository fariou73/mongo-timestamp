package org.mongo.timestamp.test;

import org.mongo.timestamp.entity.Timestamp;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {
    public static List<Timestamp> prepareTimestamps(int count) {
        List<Timestamp> result = new ArrayList<>();

        for (int i = 0; i< count; i++) {
            result.add(new Timestamp());
        }

        return result;
    }
}
