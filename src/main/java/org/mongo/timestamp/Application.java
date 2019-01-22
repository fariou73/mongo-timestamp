package org.mongo.timestamp;

import org.mongo.timestamp.config.constant.SpringProfile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class Application {
    public static final String PRINT_ARGUMENTS = "p";

    public static void main(String[] args) {
        String activeProfile = getActiveProfile(args);

        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, activeProfile);
        SpringApplication.run(Application.class, args);
    }

    public static String getActiveProfile(String[] args) {
        boolean isReader = null != args && args.length == 1 && PRINT_ARGUMENTS.equalsIgnoreCase(args[0]);
        return (isReader ? SpringProfile.READER : SpringProfile.WRITER) + "," + SpringProfile.LOGGER;
    }
}
