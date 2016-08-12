package com.conamer.vaporeon.config;

import java.io.IOException;
import java.util.MissingResourceException;
import java.util.Properties;

/**
 * Created by Conan on 12/08/2016.
 */
public abstract class AbstractPropertiesProvider implements PropertiesProvider{

    public abstract Properties getProperties();

    protected Properties getProperties(String propertiesFileName) {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream(propertiesFileName));
        } catch (IOException e) {
            throw new MissingResourceException("Missing " + propertiesFileName, this.getClass().getName(), propertiesFileName);
        }

        return properties;
    }
}
