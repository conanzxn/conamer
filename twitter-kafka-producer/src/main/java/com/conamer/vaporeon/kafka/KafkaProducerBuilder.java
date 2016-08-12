package com.conamer.vaporeon.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

/**
 * Created by Conan on 12/08/2016.
 */
public class KafkaProducerBuilder {
    private Properties properties;

    public KafkaProducerBuilder(Properties properties) {
        this.properties = properties;
    }

    public KafkaProducer<String, String> build() {
        return new KafkaProducer<>(properties);
    }

}
