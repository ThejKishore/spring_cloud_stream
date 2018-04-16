package com.kish.cloud.streamsamples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * This is a listener class that monitors the greetings topic and tries to fetch the message posted and print it....
 */


@Service
public class GreetingStreamListener {

    private static final Logger log = LoggerFactory.getLogger(GreetingStreamListener.class);

    @StreamListener(GreetingsStream.INPUT)
    public void receiveMessges(@Payload Greetings greetings){
        log.info("Message recieved from the topic GreetingStreamListener {} ",greetings);
    }
}
