package com.kish.cloud.streamsamples;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {


    private static final Logger log = LoggerFactory.getLogger(GreetingsController.class);


    private GreetingsStreamProducer greetingsStreamProducer;

    public GreetingsController(GreetingsStreamProducer greetingsStreamProducer){
        this.greetingsStreamProducer = greetingsStreamProducer;
    }



    @GetMapping("/greet/{msg}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void greetingMessage(@PathVariable("msg") String msg){
        log.info("Greetings Controller .... message recieved {} ",msg);
        Greetings greetings = new Greetings();
        greetings.setTimestamp(System.currentTimeMillis());
        greetings.setMessage(msg);


        greetingsStreamProducer.sendGreeting(greetings);
    }

}
