package com.conamer.vaporeon.twitter;

import com.conamer.vaporeon.kafka.KafkaProducerBuilder;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import twitter4j.RawStreamListener;

/**
 * Created by Conan on 12/08/2016.
 */
public class TwitterRawStreamListener implements RawStreamListener {

    private KafkaProducer<String, String> kafkaProducer;
    private String topic;

    public TwitterRawStreamListener(final KafkaProducer<String, String> kafkaProducer, String topic) {
        this.kafkaProducer = kafkaProducer;
        this.topic = topic;
    }

    @Override
    public void onMessage(String message) {
        kafkaProducer.send(new ProducerRecord<>(topic, message));
    }

    @Override
    public void onException(Exception e) {

    }
}
