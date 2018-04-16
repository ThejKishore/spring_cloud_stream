package com.kish.cloud.streamsamples;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class GreetingsStreamProducer {


    private static final Logger log = LoggerFactory.getLogger(GreetingsStreamProducer.class);

    private final GreetingsStream greetingsStreams;

    public GreetingsStreamProducer(GreetingsStream greetingsStreams) {
        this.greetingsStreams = greetingsStreams;

    }

    public void sendGreeting(final Greetings greetings) {

        log.info("Sending greetings {}", greetings);

        MessageChannel messageChannel = greetingsStreams.outboundGreetings();

        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
        log.info("Message sent through the Greetings Stream producer.... ");
    }


}
