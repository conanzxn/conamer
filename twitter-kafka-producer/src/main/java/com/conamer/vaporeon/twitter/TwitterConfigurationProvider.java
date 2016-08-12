package com.conamer.vaporeon.twitter;

import com.conamer.vaporeon.config.AbstractPropertiesProvider;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Properties;

/**
 * Created by Conan on 12/08/2016.
 */
public class TwitterConfigurationProvider extends AbstractPropertiesProvider {

    private static final String CONFIG_FILE_NAME = "twitter-config.properties";
    private static final String PROP_CONSUMER_KEY = "consumerkey";
    private static final String PROP_CONSUMER_SECRET = "consumersecret";
    private static final String PROP_ACCESS_TOKEN = "accesstoken";
    private static final String PROP_ACCESS_TOKEN_SECRET = "accesstokensecret";

    public Properties getProperties() {
        return super.getProperties(CONFIG_FILE_NAME);
    }

    public Configuration getConfiguration() {
        Properties properties = this.getProperties();
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setJSONStoreEnabled(true)
                .setOAuthConsumerKey(properties.getProperty(PROP_CONSUMER_KEY))
                .setOAuthConsumerSecret(properties.getProperty(PROP_CONSUMER_SECRET))
                .setOAuthAccessToken(properties.getProperty(PROP_ACCESS_TOKEN))
                .setOAuthAccessTokenSecret(properties.getProperty(PROP_ACCESS_TOKEN_SECRET));

        return configurationBuilder.build();
    }
}
