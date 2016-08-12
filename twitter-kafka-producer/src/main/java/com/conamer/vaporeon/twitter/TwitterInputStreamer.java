package com.conamer.vaporeon.twitter;

import com.conamer.vaporeon.kafka.KafkaProducerBuilder;
import com.conamer.vaporeon.kafka.KafkaPropertiesProvider;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;

import java.util.Properties;

/**
 * Created by Conan on 12/08/2016.
 */
public class TwitterInputStreamer {
    private static Logger LOGGER = LoggerFactory.getLogger(TwitterInputStreamer.class);
    private static final String KAFKA_TOPIC = "twitter-topic";

    public void stream() {
        Configuration configuration = new TwitterConfigurationProvider().getConfiguration();
        TwitterStream twitterStream = new TwitterStreamFactory(configuration).getInstance();
        Properties kafkaProperties = new KafkaPropertiesProvider().getProperties();
        KafkaProducer<String, String> kafkaProducer = new KafkaProducerBuilder(kafkaProperties).build();

        TwitterRawStreamListener rawStreamListener = new TwitterRawStreamListener(kafkaProducer, KAFKA_TOPIC);
        twitterStream.addListener(rawStreamListener);
        twitterStream.sample();
        shutdown(kafkaProducer, twitterStream);
    }

    private void shutdown(final KafkaProducer<String, String> kafkaProducer, final TwitterStream twitterStream) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            LOGGER.info("Shutting down...");
            kafkaProducer.close();
            twitterStream.shutdown();
        }));
    }
}
