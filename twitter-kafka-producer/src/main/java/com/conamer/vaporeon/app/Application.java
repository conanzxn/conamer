package com.conamer.vaporeon.app;

import com.conamer.vaporeon.twitter.TwitterInputStreamer;

/**
 * Created by Conan on 12/08/2016.
 */
public class Application {
    public static void main(String[] args) {
        new TwitterInputStreamer().stream();
    }
}
