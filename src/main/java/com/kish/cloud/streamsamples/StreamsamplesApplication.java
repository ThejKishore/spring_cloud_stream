package com.kish.cloud.streamsamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(GreetingsStream.class)
public class StreamsamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamsamplesApplication.class, args);
	}

}


