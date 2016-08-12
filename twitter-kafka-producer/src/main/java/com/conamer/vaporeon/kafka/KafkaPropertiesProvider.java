package com.conamer.vaporeon.kafka;

import com.conamer.vaporeon.config.AbstractPropertiesProvider;

import java.util.Properties;

/**
 * Created by Conan on 12/08/2016.
 */
public class KafkaPropertiesProvider extends AbstractPropertiesProvider {

    private static final String CONFIG_FILE_NAME = "kafka-config.properties";

    public Properties getProperties() {
        return super.getProperties(CONFIG_FILE_NAME);
    }
}
